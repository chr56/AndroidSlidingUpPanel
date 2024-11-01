plugins {
    alias(libs.plugins.androidGradlePlugin)
    alias(libs.plugins.kotlin.android)
}


android {
    compileSdk = 35
    buildToolsVersion = "35.0.0"
    namespace = "com.sothree.slidinguppanel.demo"

    defaultConfig {
        minSdk = 23
        targetSdk = 34

        applicationId = "com.sothree.slidinguppanel.demo"
        versionCode = 16
        versionName = "3.3.1"
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(project(":library"))

}
