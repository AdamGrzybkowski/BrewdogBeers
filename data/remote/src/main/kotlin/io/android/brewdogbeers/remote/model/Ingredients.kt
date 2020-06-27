package io.android.brewdogbeers.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredients(
    @Json(name = "malt") val malts: List<Malt>,
    @Json(name = "hops") val hops: List<Hop>
)
