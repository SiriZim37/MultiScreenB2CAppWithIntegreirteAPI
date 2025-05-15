plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // other libraries
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.hilt.gradle.plugin)
    // alias(libs.plugins.google.services)
}

android {
    namespace = "com.siri.multiscreenb2cappwithintegreirteapi"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.siri.multiscreenb2cappwithintegreirteapi"
        minSdk = 21
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

    // ------------------------ other libraries  ------------------------
    // Navigation
    implementation(libs.navigation.compose)

    //Retrofit for push notification
    implementation (libs.retrofit )
    implementation (libs.converter.gson)

    // Coil
    implementation(libs.coil.compose)
    //Paging
    implementation(libs.accompanist.pager)

    // Room dependencies
    /* other plugins settings */
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    //Dagger - Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    //System UI
    implementation(libs.accompanist.systemuicontroller)

    //Paging
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)


    // ------------------------ Test  ------------------------
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}