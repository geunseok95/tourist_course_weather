package com.professionalandroid.apps.touristspotweather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_weather_detail.view.*
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherDetailFragment(private var itemdata: itemdata, private var position: Int) : Fragment() {

    lateinit var now_time: String

    val retrofitService = ConnectRetrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_detail, container, false)
        view.location_name.text = itemdata.spotName
        view.nowtemperature.text = itemdata.th3.toString()
        view.prt_rain.text = itemdata.pop.toString()
        view.humidity.text = itemdata.rhm.toString()
        view.winddirection.text = itemdata.wd.toString()
        view.windspeed.text = itemdata.ws.toString()

        val weather = when(itemdata.sky){
            1 -> R.drawable.ic_baseline_wb_yellowsunny_24
            in 2..4 -> R.drawable.ic_baseline_cloud_24
            in 5..6 -> R.drawable.rainy
            in 7..8 -> R.drawable.ic_baseline_snow_24
            else -> R.drawable.ic_baseline_wb_yellowsunny_24
        }
        view.nowweather.setImageResource(weather)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시")
        val formatted = current.format(formatter)
        val current2 = LocalDateTime.now()
        val formatter2 = DateTimeFormatter.ofPattern("yyyyMMddHH")
        now_time = current.format(formatter2)

        view.nowdate.text = formatted
//
//        val connect_server = retrofitService.retrofitService()
//        connect_server.getdetailinfo(
//            1360000,
//            "TourStnInfoService",
//            10,
//            1,
//            "JSON",
//            Integer.parseInt(now_time),
//            24,
//            13
//        ).enqueue(object : retrofit2.Callback<detail_weather> {
//            override fun onFailure(call: Call<detail_weather>, t: Throwable) {
//                Log.d("test", "Fail")
//            }
//
//            override fun onResponse(call: Call<detail_weather>, response: Response<detail_weather>) {
//                val detail_weather: detail_weather = response.body()!!
//                val detail_weather_list = detail_weather.response.body.items.item[position]
//                view.uv.text = detail_weather_list.uvIndex.toString()
//
//            }
//        })

        return view
    }

}