plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.9.10"
    kotlin("kapt")
}

android {
    namespace = "com.example.snapshotStateListWeather"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.snapshotStateListWeather"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.hilt.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    // from network layer
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    // from data layer
    kapt ("com.google.dagger:hilt-android-compiler:2.48")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // from domain layer

    // for Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // room
    val room_version = "2.6.1"

    implementation ("androidx.room:room-ktx:$room_version") // Update to the latest version if needed

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    // Hilt integration with Jetpack Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // for pagination
    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha17")

    // retrofit logging
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
}