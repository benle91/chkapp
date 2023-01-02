import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        //apply default required plugins
        project.run {
            plugins.run {
                apply(AppConfig.PluginsDependencies.androidLibrary)
                apply(AppConfig.PluginsDependencies.kotlinAndroid)
                apply(AppConfig.PluginsDependencies.kotlinKapt)
                apply(AppConfig.PluginsDependencies.kotlinParcelize)
            }

            // Configure common android build parameters.
            extensions.getByName("android").run {
                if (this is LibraryExtension) {
                    task("library_plugin") {
                        doLast {
                            println("project id= ${project.displayName}")
                        }
                    }
                    compileSdkVersion(AppConfig.compileSdk)
                    defaultConfig {
                        minSdkVersion(AppConfig.minSdk)
                        testInstrumentationRunner = AppConfig.androidTestInstrumentation
                        proguardFile(AppConfig.proguardRules)
                    }

                    buildTypes {
                        getByName(AppConfig.BuildTypes.staging) {}
                    }

                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_11
                        targetCompatibility = JavaVersion.VERSION_11
                    }

                    testOptions {
                        unitTests.isIncludeAndroidResources = true
                        unitTests.all {
                            it.jvmArgs?.add("-noverify")
                        }
                    }
                    val sources = listOf(
                        "src/main/java",
                    )
                    sourceSets {
                        getByName("main").java.setSrcDirs(sources)
                    }
                }
            }
            dependencies {
                for (dp in Dependencies.libDefault) {
                    add("implementation", dp)
                }
            }
        }
    }
}