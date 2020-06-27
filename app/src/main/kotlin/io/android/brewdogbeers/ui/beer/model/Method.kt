package io.android.brewdogbeers.ui.beer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Method(
    val mashTemp: List<String>,
    val fermentation: String,
    val twist: String?
) : Parcelable
