package io.android.brewdogbeers.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.android.brewdogbeers.ui.beers.BeersFragment

@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindBeersFragment(): BeersFragment
}
