plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.superhero"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.superhero"
        minSdk = 26

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
        sourceCompatibility = JavaVersion.VERSION_14
        targetCompatibility = JavaVersion.VERSION_14
    }
    kotlinOptions {
        jvmTarget = "14"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    // Retrofit & GsonConverterFactory


    implementation(libs.retrofit)
    implementation(libs.converter.gson)


    // Picasso
    implementation (libs.picasso)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    implementation (libs.androidx.core.splashscreen)

}