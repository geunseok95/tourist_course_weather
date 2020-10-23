package com.professionalandroid.apps.touristspotweather

import com.google.gson.annotations.SerializedName


data class weather(
    var response: responose
)

data class responose(
    @SerializedName("header")
    var header: header,
    @SerializedName("body")
    var body: body
)

data class header(
    @SerializedName("resultCode")
    var resultCode: String,
    @SerializedName("resultMsg")
    var resultMsg: String
)

data class body(
    @SerializedName("dataType")
    var dataType: String,
    @SerializedName("items")
    var items: item,
    @SerializedName("pageNo")
    var pageNo: Int,
    @SerializedName("numOfRows")
    var numOfRows: Int,
    @SerializedName("totalCount")
    var totalCount: Int
)

data class item(
    var item:List<itemdata>
)

data class itemdata (
    @SerializedName("courseAreaId")
    var courseAreaId: String,

    @SerializedName("courseAreaName")
    var courseAreaName: String,

    @SerializedName("courseId")
    var courseId: String,

    @SerializedName("courseName")
    var courseName: String,

    @SerializedName("pop")
    var pop: Int,

    @SerializedName("rhm")
    var rhm: Int,

    @SerializedName("sky")
    var sky: Int,

    @SerializedName("spotAreaId")
    var spotAreaId: Int,

    @SerializedName("spotAreaName")
    var spotAreaName: String,

    @SerializedName("spotName")
    var spotName: String,

    @SerializedName("th3")
    var th3: Int,

    @SerializedName("thema")
    var thema: String,

    @SerializedName("tm")
    var tm: String,

    @SerializedName("wd")
    var wd: Int,

    @SerializedName("ws")
    var ws: Float
)

data class detail_weather(
    @SerializedName("response")
    var response: response2
)

data class response2(
    @SerializedName("header")
    var header: header2,
    @SerializedName("body")
    var body: body2
)

data class header2(
    @SerializedName("resultCode")
    var resultCode: String,
    @SerializedName("resultMsg")
    var resultMsg: String
)

data class body2(
    @SerializedName("dataType")
    var dataType: String,
    @SerializedName("items")
    var items: item2,
    @SerializedName("pageNo")
    var pageNo: Int,
    @SerializedName("numOfRows")
    var numOfRows: Int,
    @SerializedName("totalCount")
    var totalCount: Int
)

data class item2(
    @SerializedName("item")
    var item:List<itemdata2>
)

data class itemdata2(
    @SerializedName("btIndex")
    var btIndex:String?,

    @SerializedName("courseAreaId")
    var courseAreaId: String,

    @SerializedName("courseAreaName")
    var courseAreaName: String,

    @SerializedName("courseId")
    var courseId: String,

    @SerializedName("courseName")
    var courseName: String,

    @SerializedName("fdIndex")
    var fdIndex: Int,

    @SerializedName("spotAreaId")
    var spotAreaId: Int,

    @SerializedName("spotAreaName")
    var spotAreaName: String,

    @SerializedName("spotName")
    var spotName: String,

    @SerializedName("thema")
    var thema: String,

    @SerializedName("tm")
    var tm: String,

    @SerializedName("uvIndex")
    var uvIndex: Int,

    @SerializedName("htIndex")
    var htIndex: String?,

    @SerializedName("dsIndex")
    var dsIndex: String?,

    @SerializedName("piIndexCharm")
    var piIndexCharm: String?,

    @SerializedName("piIndexSo ")
    var piIndexSo : String?,

    @SerializedName("piIndexWeed ")
    var piIndexWeed : String?
)