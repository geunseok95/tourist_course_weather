package com.professionalandroid.apps.touristspotweather

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.professionalandroid.apps.touristspotweather.MainActivity.Companion.course_list
import com.professionalandroid.apps.touristspotweather.MainActivity.Companion.tourist_spot
import com.professionalandroid.apps.touristspotweather.MainActivity.Companion.tourist_spot_list
import kotlinx.android.synthetic.main.fragment_recyclerview_page.*
import kotlinx.android.synthetic.main.fragment_recyclerview_page.view.*
import kotlinx.android.synthetic.main.fragment_weather.view.*
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherFragment : Fragment(){
    val retrofitService = ConnectRetrofit
    var arrayadapter: ArrayAdapter<String>? = null
    lateinit var now_time: String
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arrayadapter =  ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, tourist_spot)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHH")
        now_time = current.format(formatter)

        view.autoCompleteTextView.setAdapter(arrayadapter)
//        for(i in tourist_spot.indices){
//            Log.d("test", tourist_spot[i])
//        }

        view.search_btn.setOnClickListener {
            val serch_text = view.autoCompleteTextView.text.toString()
            val course_Id: String? = tourist_spot_list[serch_text]

            Log.d("test",serch_text + course_Id.toString())

            if(course_Id != null) {
                val connect_server = retrofitService.retrofitService()
                connect_server.getweatherinfo(
                    1360000,
                    "TourStnInfoService",
                    10,
                    1,
                    "JSON",
                    Integer.parseInt(now_time),
                    24,
                    Integer.parseInt(course_Id)
                ).enqueue(object : retrofit2.Callback<weather> {
                    override fun onFailure(call: Call<weather>, t: Throwable) {
                        Log.d("test", "Fail")
                    }

                    override fun onResponse(call: Call<weather>, response: Response<weather>) {
                        val weatherdata:weather = response.body()!!
                        val tourist_course_list = weatherdata.response.body.items
                        val recyclerviewpage = RecyclerviewPage(tourist_course_list)
                        (activity as MainActivity).changefragment(recyclerviewpage)
                    }
                })
            }
        }
        return view
    }




}