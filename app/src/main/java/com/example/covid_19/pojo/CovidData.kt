package com.example.covid_19.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Class used to hold response for COVID-19 data
 */
class CovidData {
    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("cases")
    @Expose
    var cases: String? = null

    @SerializedName("todayCases")
    @Expose
    var todayCases: String? = null

    @SerializedName("deaths")
    @Expose
    var deaths: String? = null

    @SerializedName("todayDeaths")
    @Expose
    var todayDeaths: String? = null

    @SerializedName("recovered")
    @Expose
    var recovered: String? = null

    @SerializedName("todayRecovered")
    @Expose
    var todayRecovered: String? = null

    @SerializedName("active")
    @Expose
    var active: String? = null

    @SerializedName("critical")
    @Expose
    var critical: String? = null

    @SerializedName("casesPerOneMillion")
    @Expose
    var casesPerOneMillion: String? = null

    @SerializedName("deathsPerOneMillion")
    @Expose
    var deathsPerOneMillion: Double? = null

    @SerializedName("tests")
    @Expose
    var tests: String? = null

    @SerializedName("testsPerOneMillion")
    @Expose
    var testsPerOneMillion: Double? = null

    @SerializedName("population")
    @Expose
    var population: String? = null

    @SerializedName("activePerOneMillion")
    @Expose
    var activePerOneMillion: Double? = null

    @SerializedName("recoveredPerOneMillion")
    @Expose
    var recoveredPerOneMillion: Double? = null

    @SerializedName("criticalPerOneMillion")
    @Expose
    var criticalPerOneMillion: Double? = null

    @SerializedName("affectedCountries")
    @Expose
    var affectedCountries: String? = null
}