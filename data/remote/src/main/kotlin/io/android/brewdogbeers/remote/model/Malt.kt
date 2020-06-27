package io.android.brewdogbeers.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Malt(
    @Json(name = "name") val name: String,
    @Json(name = "amount") val amount: Amount
) {

    @JsonClass(generateAdapter = true)
    data class Amount(
        @Json(name = "value") val value: Float,
        @Json(name = "unit") val unit: String
    )
}
