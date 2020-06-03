package com.example.covid_19.network

import com.example.covid_19.pojo.CovidData
import retrofit2.Call
import retrofit2.http.GET

/**
 * interface class to make network API calls
 */
interface ApiInterface {
    // Get all covid-19 data
    @GET("v2/all")
    fun getCovidData(): Call<CovidData>
}