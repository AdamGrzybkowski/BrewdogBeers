package io.android.brewdogbeers.domain.source

import io.android.brewdogbeers.domain.model.Beer

interface BeerSource {

    suspend fun getBeers(): List<Beer>
}
