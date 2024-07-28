// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    // STEP 1: Apply the Kotlin JVM (or Kotlin Android plugin)
    //id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
    // STEP 2: Apply the KSP plugin
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
}