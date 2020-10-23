package com.professionalandroid.apps.touristspotweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.fragment_detail.view.*
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetailFragment : Fragment() {

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
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHH")
        now_time = current.format(formatter)

        val connect_server = retrofitService.retrofitService()
        connect_server.getdetailinfo(
            1360000,
            "TourStnInfoService",
            10,
            1,
            "JSON",
            Integer.parseInt(now_time),
            24,
            13
        ).enqueue(object : retrofit2.Callback<detail_weather> {
            override fun onFailure(call: Call<detail_weather>, t: Throwable) {
                Log.d("test", "Fail")
            }
            override fun onResponse(call: Call<detail_weather>, response: Response<detail_weather>) {
                Log.d("test", response.toString())
                val body = response.body()!!
                Log.d("test", body.toString())
            }
        })

        view.logout.setOnClickListener {
            LoginManager.getInstance().logOut()
            val intent = Intent(context, LoginPage::class.java)
            startActivity(intent)
        }

        view.my_info_name.text = MainActivity.name
        view.my_info_email.text = MainActivity.email



        return view
    }

}