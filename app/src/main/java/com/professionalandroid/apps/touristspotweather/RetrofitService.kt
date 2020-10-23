package com.professionalandroid.apps.touristspotweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("{path1}/{path2}/getTourStnVilageFcst?ServiceKey=97hZvTFc5wWpg7lm4D89rdYtyRo14y2sJkFe%2B1goEvYZ7g1vS6Po%2FSWAKhyjZoxqfTVm8qMdY5c%2FS5a5OhloyQ%3D%3D")
    fun getweatherinfo(
        @Path("path1") path1: Int,
        @Path("path2") path2: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("dataType") dataType: String,
        @Query("CURRENT_DATE") CURRENT_DATE: Int,
        @Query("HOUR") HOUR: Int,
        @Query("COURSE_ID") COURSE_ID: Int
    ): Call<weather>

    @GET("{path1}/{path2}/getTourStnWthrIdx?ServiceKey=97hZvTFc5wWpg7lm4D89rdYtyRo14y2sJkFe%2B1goEvYZ7g1vS6Po%2FSWAKhyjZoxqfTVm8qMdY5c%2FS5a5OhloyQ%3D%3D")
    fun getdetailinfo(
        @Path("path1") path1: Int,
        @Path("path2") path2: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("dataType") dataType: String,
        @Query("CURRENT_DATE") CURRENT_DATE: Int,
        @Query("HOUR") HOUR: Int,
        @Query("detail_weather") COURSE_ID: Int
    ): Call<detail_weather>
}