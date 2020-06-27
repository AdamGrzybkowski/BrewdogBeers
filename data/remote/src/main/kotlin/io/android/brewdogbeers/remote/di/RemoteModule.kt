package io.android.brewdogbeers.remote.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.android.brewdogbeers.domain.source.BeerSource
import io.android.brewdogbeers.remote.api.BrewdogApi
import io.android.brewdogbeers.remote.source.RemoteBeerSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
abstract class RemoteModule {

    @Module
    companion object {

        @Provides
        fun brewdogApi(): BrewdogApi {
            return Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(BrewdogApi::class.java)
        }
    }

    @Binds
    @Reusable
    abstract fun bindBeerSource(impl: RemoteBeerSource): BeerSource
}
