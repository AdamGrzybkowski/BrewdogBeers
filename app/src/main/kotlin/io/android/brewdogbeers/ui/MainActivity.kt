package io.android.brewdogbeers.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.android.brewdogbeers.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
