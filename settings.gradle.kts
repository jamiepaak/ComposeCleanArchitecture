pluginManagement {
//    includeBuild("build-logic")
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
rootProject.name = "ComposeCleanArchitecture"
include(":app")
include(":core:network")
include(":core:design-system")
include(":core:data:github")
include(":core:domain:github")
include(":core:database:github")
include(":core:database:github-api")
include(":feature:github-search")