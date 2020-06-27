package io.android.brewdogbeers.domain.usecase

import io.android.brewdogbeers.domain.model.Beer
import io.android.brewdogbeers.domain.source.BeerSource
import javax.inject.Inject

class GetBeers @Inject constructor(
    private val beerSource: BeerSource
) : UseCase<Unit, List<Beer>> {

    override suspend fun invoke(param: Unit): List<Beer> = beerSource.getBeers()
}
