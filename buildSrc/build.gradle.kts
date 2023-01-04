plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://dl.google.com/dl/android/maven2")
    }
}


gradlePlugin {
    plugins {
        register("library-plugin") {
            id = "library-plugin"
            implementationClass = "LibraryPlugin"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("gradle-plugin", version = "1.5.0"))
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("com.google.gms:google-services:4.3.14")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.7.20")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    implementation("io.michaelrocks:paranoid-gradle-plugin:0.3.7")
    implementation("org.jacoco:org.jacoco.core:0.8.7")
    implementation(platform("com.google.firebase:firebase-bom:31.1.1"))

}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}