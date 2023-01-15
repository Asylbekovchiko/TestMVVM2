package com.example.testmvvm2.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCountries {

	private val baseUrl = "https://restcountries.com/"

	private fun getHttpLogInterceptor() = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY
	}

	private val okHttpClients = OkHttpClient.Builder().addInterceptor(getHttpLogInterceptor())

	private fun getInitRetrofit(): Retrofit =
		Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.client(okHttpClients.build())
			.build()

	fun getRetrofit() = getInitRetrofit()
}