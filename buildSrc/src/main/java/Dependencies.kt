object ApplicationId {
    val id = "com.example.mcc_intrado"
}

object Modules {
//    val app = ":app"
//    val navigation = ":navigation"
//
//    val cache = ":common:cache"
//    val network = ":common:network"
//
//    val presentation = ":common:presentation"
//
//    val sample = ":sample"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}


object Kotlin {
    const val kotlin = "1.3.70"
}

object Gradle {
    const val gradle = "3.6.1"
}


object AndroidSdk {
    const val compileSdk = 28
    const val minSdk = 16
    const val targetSdk = 28
}


object Versions {

    const val googleAuth = "16.0.1"
    const val googleLocation = "17.0.0"
    const val googleServices = "4.3.3"

    const val firebaseAuth = "16.0.4"
    const val firebaseCore = "17.2.1"

    const val fabric = "1.31.2"

    const val room = "2.2.5"
    const val media = "1.2.0"
    const val appcompat = "1.2.0"
    const val design = "1.2.1"
    const val cardview = "1.0.0"
    const val recyclerview = "1.1.0"
    const val swiperefreshlayout = "1.0.0"
    const val constraintlayout = "2.0.4"
    const val vectordrawable = "1.1.0"
    const val navigationFragmentKtx = "2.2.1"
    const val navigationUI = "2.2.1"
    const val livedata = "2.2.0"

    const val coroutinesAndroid = "1.3.9"
    const val coroutinesCore = "1.3.9"

    const val maps = "15.0.1"

    const val ktx = "1.3.2"

    const val timber = "4.7.1"
    const val rxkotlin = "2.4.0"
    const val rxAndroid = "2.0.2"
    const val retrofit = "2.7.2"
    const val okhttp = "4.9.0"
    const val loggingInterceptor = "4.2.2"
    const val glide = "4.11.0"
    const val rxpaper = "1.4.0"
    const val paperdb = "2.6"
    const val moshi = "1.8.0"
    const val lifecycle = "2.2.0"
    const val leakCanary = "2.0"
    const val crashlytics = "2.10.1"
    const val koin = "2.1.4"
    const val picasso = "2.8"
    const val gson = "2.8.5"
    const val eventbus = "3.1.1"
    const val dagger = "2.29.1"
    const val reactiveLocation = "2.1@aar"
    const val permissions = 3.8
    const val playCore = "1.6.4"

    const val junit = "4.12"
    const val assertjCore = "3.14.0"
    const val mockitoKotlin = "2.1.0"
    const val mockitoInline = "3.2.4"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Kotlin.kotlin}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    const val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val scalarsConverter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val paperdb = "io.paperdb:paperdb:${Versions.paperdb}"
    const val rxpaper = "com.github.pakoito:RxPaper2:${Versions.rxpaper}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val eventbus = "org.greenrobot:eventbus:${Versions.eventbus}"

    const val leakCanaryAndroid = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val reactiveLocation = "pl.charmas.android:android-reactive-location2:${Versions.reactiveLocation}"
    const val permissions = "com.nabinbhandari.android:permissions:${Versions.permissions}"
}

object Androidx {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.design}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val vectordrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectordrawable}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragmentKtx}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUI}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx::${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val media = "androidx.media:media:${Versions.media}"
}

object Jetbrains {
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
}

object GoogleLibraries {
    const val auth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"
    const val playCore = "com.google.android.play:core:${Versions.playCore}"
    const val playLocation = "com.google.android.gms:play-services-location:${Versions.googleLocation}"
}

object FirebaseLibraries {
    const val auth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"
    const val core = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
}
