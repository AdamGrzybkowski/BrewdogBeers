package io.android.brewdogbeers.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.android.brewdogbeers.BrewdogApp
import io.android.brewdogbeers.di.module.ActivityBindingModule
import io.android.brewdogbeers.remote.di.RemoteModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        RemoteModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BrewdogApp> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): ApplicationComponent
    }
}
