package io.android.brewdogbeers.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.android.brewdogbeers.ui.beer.detail.BeerDetailsFragment
import io.android.brewdogbeers.ui.beer.list.BeersFragment

@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindBeersFragment(): BeersFragment

    @ContributesAndroidInjector
    abstract fun bindBeerDetailsFragment(): BeerDetailsFragment
}
