import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val kotlinSerialization =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinSerialization}"
    const val paranoid = "io.michaelrocks:paranoid-gradle-plugin:${Versions.paranoid}"

    /**
     * lib
     * */
    private const val coreKTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    private const val navigationFragmentKTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragmentKTX}"
    private const val navigationUIKTX =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationUIKTX}"

    /**
     * lib test
     * */
    private const val junit = "junit:junit:${Versions.junit}"
    private const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    private const val androidEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidEspressoCore}"


    val libDefault = listOf<String>(
        coreKTX, appcompat, material, constraintlayout, navigationFragmentKTX, navigationUIKTX
    )

    val libUnitTest = listOf<String>(junit)
    val libAndroidTest = listOf<String>(androidJunit, androidEspressoCore)


}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.annotationProcessor(list: List<String>) {
    list.forEach { dependency ->
        add("annotationProcessor", dependency)
    }
}


