package io.android.brewdogbeers.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beer(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "image_url") val image: String,
    @Json(name = "abv") val abv: Float,
    @Json(name = "ingredients") val ingredients: Ingredients,
    @Json(name = "method") val method: Method
)
