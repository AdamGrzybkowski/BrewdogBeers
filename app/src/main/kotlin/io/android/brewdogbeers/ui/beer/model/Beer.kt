package io.android.brewdogbeers.ui.beer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beer(
    val id: Long,
    val name: String,
    val abv: Float,
    val description: String,
    val image: String,
    val hops: List<String>,
    val malts: List<String>,
    val method: Method
) : Parcelable
