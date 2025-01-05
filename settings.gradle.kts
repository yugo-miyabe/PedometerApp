pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "PedometerApp"
include(":app")
include(":core")
include(":core:common")
include(":core:datasource")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:repository")
include(":core:system")
include(":core:ui")
include(":core:usecase")
include(":feature")
include(":feature:home")
include(":feature:setting")
include(":feature:timeline")
include(":feature:tutorial")
