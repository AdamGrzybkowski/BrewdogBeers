package io.android.brewdogbeers.domain.model

data class Beer(
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
    val abv: Float,
    val malts: List<Malt>,
    val hops: List<Hop>,
    val methods: Method
)
