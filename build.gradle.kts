plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.roborazzi) apply false
    alias(libs.plugins.detekt)
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.detekt.gradle.plugin)
    }
}

allprojects {
    subprojects {
        apply(plugin = "io.gitlab.arturbosch.detekt")
    }
}
