package io.android.brewdogbeers.remote.api

import io.android.brewdogbeers.remote.model.Beer
import retrofit2.http.GET

interface BrewdogApi {

    @GET("beers")
    suspend fun getBeers(): List<Beer>
}
