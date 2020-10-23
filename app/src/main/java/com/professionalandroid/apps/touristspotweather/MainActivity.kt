package com.professionalandroid.apps.touristspotweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.opencsv.CSVReader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer

class   MainActivity : AppCompatActivity() {

    companion object{
        val tourist_spot = mutableListOf<String>() // courseName
        val tourist_spot_list = mutableMapOf<String, String>() // courseName and courseId ex)  올레여행 13코스 (용수저지 올레) - 407
        val course_list = mutableMapOf<String, MutableList<String>>() // courseId and spotNameList
        var name: String? = null
        var email: String? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputstream: InputStreamReader = InputStreamReader(resources.openRawResource(R.raw.tourlist))
        var reader: BufferedReader = BufferedReader(inputstream)
        var csvreader: CSVReader = CSVReader(reader)
        var record = csvreader.readNext()

        while(record != null){
            tourist_spot.add(record[1])
            tourist_spot_list[record[1]] = record[0]
            record = csvreader.readNext()
        }

        inputstream = InputStreamReader(resources.openRawResource(R.raw.datafile))
        reader = BufferedReader(inputstream)
        csvreader = CSVReader(reader)
        record = csvreader.readNext()

        while(record != null){
            if(course_list[record[1]].isNullOrEmpty()){
                course_list[record[1]] = mutableListOf(record[4])
            }
            else{
                course_list[record[1]]?.add(record[4])
            }
            record = csvreader.readNext()
        }

        val weatherpage = WeatherFragment()
        val detailpage = DetailFragment()

        val ft = supportFragmentManager

        ft.beginTransaction().replace(R.id.main_layout, weatherpage).commit()

        bottom_navigation_bar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_bar_weather -> ft.beginTransaction().replace(R.id.main_layout, weatherpage).commit()
                R.id.navigation_bar_detail -> ft.beginTransaction().replace(R.id.main_layout, detailpage).commit()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun changefragment(fragment:Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.recyclerview, fragment)
        ft.commit()
    }

    fun move_next_fragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}