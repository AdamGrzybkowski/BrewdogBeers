package io.android.brewdogbeers.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Method(
    @Json(name = "mash_temp") val mashTemp: List<MashTemp>,
    @Json(name = "fermentation") val fermentation: Fermentation,
    @Json(name = "twist") val twist: String?
) {

    @JsonClass(generateAdapter = true)
    data class MashTemp(
        @Json(name = "temp") val temperature: Temperature,
        @Json(name = "duration") val duration: Float?
    )

    @JsonClass(generateAdapter = true)
    data class Fermentation(
        @Json(name = "temp") val temperature: Temperature
    )

    @JsonClass(generateAdapter = true)
    data class Temperature(
        @Json(name = "value") val value: Float,
        @Json(name = "unit") val unit: String
    )
}
