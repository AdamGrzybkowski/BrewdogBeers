package io.android.brewdogbeers.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.android.brewdogbeers.ui.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
    abstract fun bindMainActivity(): MainActivity
}
