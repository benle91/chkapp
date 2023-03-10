object AppConfig {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardRules =  "proguard-rules.pro"
    const val namespace =  "hien.android.chk"

    object PluginId {
        const val libraryPlugin = "library-plugin"
    }

    object PluginsDependencies {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinParcelize = "kotlin-parcelize"
        const val kotlinKapt = "kotlin-kapt"
        const val googleServices = "com.google.gms.google-services"
        const val kotlinSerialization = "kotlinx-serialization"
        const val paranoid = "io.michaelrocks.paranoid"
        const val dynamicFeature = "com.android.dynamic-feature"
        const val androidLibrary = "com.android.library"
    }

    object BuildTypes {
        const val staging = "debug"
    }
}