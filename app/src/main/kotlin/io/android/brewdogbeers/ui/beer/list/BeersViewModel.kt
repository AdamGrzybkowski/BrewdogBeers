package io.android.brewdogbeers.ui.beer.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.android.brewdogbeers.domain.model.Beer
import io.android.brewdogbeers.domain.model.Method
import io.android.brewdogbeers.ui.beer.model.Beer as ViewBeer
import io.android.brewdogbeers.ui.beer.model.Method as ViewMethod
import io.android.brewdogbeers.domain.usecase.GetBeers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BeersViewModel @Inject constructor(
    getBeers: GetBeers
) : ViewModel() {

    private val _beers = MutableLiveData<List<ViewBeer>>()
    val beers: LiveData<List<ViewBeer>> = _beers

    init {
        viewModelScope.launch {
            runCatching { getBeers(Unit) }
                .onSuccess { newBeers ->
                    _beers.value = newBeers.map { it.toViewModel() }
                }
                .onFailure {
                    // sth went wrong, handle exception
                }
        }
    }
}

private fun Beer.toViewModel(): ViewBeer {
    return ViewBeer(
        id = id,
        image = image,
        abv = abv,
        name = name,
        description = description,
        malts = malts.map { "${it.name} ${it.amount.value} ${it.amount.unit}" },
        hops = hops.map { "${it.name} ${it.amount.value} ${it.amount.unit}" },
        method = methods.toViewModel()
    )
}

private fun Method.toViewModel(): ViewMethod {
    return ViewMethod(
        mashTemp = mashTemp.map {
            "${it.temperature.value} ${it.temperature.unit} ${it.duration?.toString().orEmpty()}"
        },
        fermentation = "${fermentation.temperature.value} ${fermentation.temperature.unit}",
        twist = twist
    )
}
