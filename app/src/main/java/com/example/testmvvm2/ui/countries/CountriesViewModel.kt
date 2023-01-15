package com.example.testmvvm2.ui.countries

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmvvm2.data.model.countries.CountriesResponseItem
import com.example.testmvvm2.data.repo.CountriesRepository
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {

	private val countriesRepository = CountriesRepository()

	private var _successLiveData: MutableLiveData<ArrayList<CountriesResponseItem>> =
		MutableLiveData()
	val successLiveData: LiveData<ArrayList<CountriesResponseItem>> = _successLiveData

	private var _errorLiveData: MutableLiveData<String> = MutableLiveData()
	val errorLiveData: LiveData<String> = _errorLiveData

	fun getCountries() {
		viewModelScope.launch {
			val response = countriesRepository.getCountries()
			when {
				response.isSuccessful -> {
					_successLiveData.value = response.body()
				}
				response.errorBody() != null -> {
					_errorLiveData.value = response.errorBody().toString()
				}
			}
		}
	}
}