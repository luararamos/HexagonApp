plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.luaramartins.hexagonapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.luaramartins.hexagonapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Jetpack Compose dependencies
    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation (platform("androidx.compose:compose-bom:2022.10.00"))
    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.compose.ui:ui-graphics:1.5.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation ("androidx.compose.material:material:1.5.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.0")
    implementation ("androidx.compose.runtime:runtime:1.5.0")

    // Jetpack Compose toolings
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

    // Other dependencies
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.navigation:navigation-compose:2.8.0")


    // Koin for Dependency Injection
    implementation("io.insert-koin:koin-android:3.4.0")
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.insert-koin:koin-android-compat:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")

    implementation("io.coil-kt:coil-compose:2.1.0")

    //ROOM
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")
    implementation ("androidx.room:room-paging:2.6.1")

    // Coroutines Core
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Coroutines Android (necessário para lidar com o ciclo de vida no Android)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


}