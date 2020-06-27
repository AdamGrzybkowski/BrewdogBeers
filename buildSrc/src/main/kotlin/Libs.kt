object Libs {
    private const val kotlinVersion = "1.3.72"
    private const val kotlinCoroutinesVersion = "1.3.7"
    private const val daggerVersion = "2.28.1"
    private const val retrofitVersion = "2.9.0"
    private const val navigationVersion = "2.3.0"
    private const val lifecycleVersion = "2.2.0"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion"
    const val appCompat = "androidx.appcompat:appcompat:1.2.0-rc01"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta7"
    const val material = "com.google.android.material:material:1.3.0-alpha01"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"

    const val javaxInject = "javax.inject:javax.inject:1"

    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerProccessor = "com.google.dagger:dagger-compiler:$daggerVersion"
    const val daggerAndroid = "com.google.dagger:dagger-android-support:$daggerVersion"
    const val daggerAndroidProccessor = "com.google.dagger:dagger-android-processor:$daggerVersion"

    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val moshi = "com.squareup.moshi:moshi:1.9.3"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:1.9.3"

    const val coil = "io.coil-kt:coil:0.11.0"
}
