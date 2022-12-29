plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("gradle-plugin", version = "1.5.0"))
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("com.google.gms:google-services:4.3.13")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.0-RC")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")
    implementation("io.michaelrocks:paranoid-gradle-plugin:0.3.7")
    implementation("org.jacoco:org.jacoco.core:0.8.7")

}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}