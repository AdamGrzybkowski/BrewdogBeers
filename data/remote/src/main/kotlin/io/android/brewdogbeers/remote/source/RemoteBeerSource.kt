package io.android.brewdogbeers.remote.source

import io.android.brewdogbeers.domain.model.Beer as DomainBeer
import io.android.brewdogbeers.domain.model.Hop as DomainHop
import io.android.brewdogbeers.domain.model.Hop.Amount as DomainHopAmount
import io.android.brewdogbeers.domain.model.Malt as DomainMalt
import io.android.brewdogbeers.domain.model.Malt.Amount as DomainMaltAmount
import io.android.brewdogbeers.domain.model.Method as DomainMethod
import io.android.brewdogbeers.domain.model.Method.MashTemp as DomainMashTemp
import io.android.brewdogbeers.domain.model.Method.Temperature as DomainMethodTemperature
import io.android.brewdogbeers.domain.model.Method.Fermentation as DomainFermentation
import io.android.brewdogbeers.domain.source.BeerSource
import io.android.brewdogbeers.remote.api.BrewdogApi
import io.android.brewdogbeers.remote.model.Beer
import io.android.brewdogbeers.remote.model.Hop
import io.android.brewdogbeers.remote.model.Malt
import io.android.brewdogbeers.remote.model.Method
import javax.inject.Inject

class RemoteBeerSource @Inject constructor(
    private val brewdogApi: BrewdogApi
) : BeerSource {

    override suspend fun getBeers(): List<DomainBeer> {
        return brewdogApi.getBeers()
            .map { beer -> beer.toDomainModel() }
    }
}

private fun Beer.toDomainModel(): DomainBeer {
    return DomainBeer(
        id = id,
        name = name,
        abv = abv,
        description = description,
        image = image,
        hops = ingredients.hops.map { it.toDomainModel() },
        malts = ingredients.malts.map { it.toDomainModel() },
        methods = method.toDomainModel()
    )
}

private fun Hop.toDomainModel(): DomainHop {
    return DomainHop(
        name = name,
        amount = DomainHopAmount(
            value = amount.value,
            unit = amount.unit
        )
    )
}

private fun Malt.toDomainModel(): DomainMalt {
    return DomainMalt(
        name = name,
        amount = DomainMaltAmount(
            value = amount.value,
            unit = amount.unit
        )
    )
}

private fun Method.toDomainModel(): DomainMethod {
    return DomainMethod(
        mashTemp = mashTemp.map { it.toDomainModel() },
        fermentation = fermentation.toDomainModel(),
        twist = twist
    )
}

private fun Method.MashTemp.toDomainModel(): DomainMashTemp {
    return DomainMashTemp(
        temperature = DomainMethodTemperature(
            value = temperature.value,
            unit = temperature.unit
        ),
        duration = duration
    )
}

private fun Method.Fermentation.toDomainModel(): DomainFermentation {
    return DomainFermentation(
        temperature = DomainMethodTemperature(
            value = temperature.value,
            unit = temperature.unit
        )
    )
}
