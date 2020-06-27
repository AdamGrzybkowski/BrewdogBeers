package io.android.brewdogbeers

import dagger.android.support.DaggerApplication
import io.android.brewdogbeers.di.DaggerApplicationComponent

class BrewdogApp : DaggerApplication() {

    override fun applicationInjector() = DaggerApplicationComponent.factory().create(this)
}
