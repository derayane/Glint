pluginManagement {
    repositories {
        google()
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

rootProject.name = "Glint"
include(":core-ui")
include(":components")
include(":catalog")

// Workaround for version catalog in buildscript
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}
