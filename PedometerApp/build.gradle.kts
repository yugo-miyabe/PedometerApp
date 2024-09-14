plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt)
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
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
