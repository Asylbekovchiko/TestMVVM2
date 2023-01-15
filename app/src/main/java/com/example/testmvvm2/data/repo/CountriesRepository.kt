package com.example.testmvvm2.data.repo

import com.example.testmvvm2.data.api.CountriesApi
import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import com.example.testmvvm2.network.RetrofitCountries
import retrofit2.Response

class CountriesRepository {

	private val countryApi = RetrofitCountries.getRetrofit().create(CountriesApi::class.java)

	suspend fun getCountries(): Response<ArrayList<CountriesResponseItem>> {
		return countryApi.getCountries()
	}
}