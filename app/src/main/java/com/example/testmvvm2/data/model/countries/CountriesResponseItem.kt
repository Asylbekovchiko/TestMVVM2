package com.example.testmvvm2.data.model.countries

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountriesResponseItem(
    val capital: String,
    val currencies: List<Currency>,
    val flags: Flags,
    val name: String,
    val region: String,
    val timezones: List<String>,
): Parcelable