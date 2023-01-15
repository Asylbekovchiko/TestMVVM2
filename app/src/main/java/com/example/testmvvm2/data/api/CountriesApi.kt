package com.example.testmvvm2.data.api

import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {

	@GET("/v2/all?fields=name,capital,currencies,region,timezones,flags")
	suspend fun getCountries(): Response<ArrayList<CountriesResponseItem>>
}