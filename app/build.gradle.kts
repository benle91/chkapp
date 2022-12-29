plugins {
    id(AppConfig.PluginsDependencies.androidApplication)
    id(AppConfig.PluginsDependencies.kotlinAndroid)
    id(AppConfig.PluginsDependencies.kotlinParcelize)
    id(AppConfig.PluginsDependencies.kotlinKapt)
    id(AppConfig.PluginsDependencies.kotlinSerialization)
    id(AppConfig.PluginsDependencies.paranoid)
}

buildscript {
    dependencies {
        classpath(Dependencies.kotlinGradlePlugin)
    }
}

android {
    namespace = "hien.android.chk"
    compileSdkVersion(AppConfig.compileSdk)

    defaultConfig {
        applicationId = "hien.android.chk"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

kapt {
    generateStubs = true
}

dependencies {
    implementation(Dependencies.libDefault)
    testImplementation(Dependencies.libUnitTest)
    androidTestImplementation(Dependencies.libAndroidTest)
    kapt(Dependencies.kotlinGradlePlugin)
}