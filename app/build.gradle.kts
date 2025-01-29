import org.jetbrains.kotlin.backend.wasm.ir2wasm.bind

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
/*
repositories {
    google()
    mavenCentral()
}
*/
android {
    namespace = "com.openclassrooms.magicgithub"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.openclassrooms.magicgithub"
        minSdk = 31
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
    //Activate binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation (libs.glide)
    implementation(libs.androidx.espresso.contrib)
    implementation(libs.androidx.junit.ktx)
    annotationProcessor (libs.compiler)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.espresso.contrib)
    androidTestImplementation(libs.androidx.rules)

    //implementation("com.github.jinatonic:confetti:1.0.0")

}