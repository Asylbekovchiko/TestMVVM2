package com.example.testmvvm2.data.model.countries

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val code: String,
    val name: String,
    val symbol: String
): Parcelable