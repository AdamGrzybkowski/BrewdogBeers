package io.android.brewdogbeers.domain.model

data class Method(
    val mashTemp: List<MashTemp>,
    val fermentation: Fermentation,
    val twist: String?
) {

    data class MashTemp(
        val temperature: Temperature,
        val duration: Float?
    )

    data class Fermentation(
        val temperature: Temperature
    )

    data class Temperature(
        val value: Float,
        val unit: String
    )
}
