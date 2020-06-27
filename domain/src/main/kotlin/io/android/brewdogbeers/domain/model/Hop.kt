package io.android.brewdogbeers.domain.model

data class Hop(
    val name: String,
    val amount: Amount
) {

    data class Amount(
        val value: Float,
        val unit: String
    )
}
