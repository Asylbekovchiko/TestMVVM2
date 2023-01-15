package com.example.testmvvm2.data.model.countries

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flags(
    val png: String,
    val svg: String
): Parcelable