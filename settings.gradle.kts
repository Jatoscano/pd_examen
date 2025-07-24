plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0" apply false
}

rootProject.name = "pd_examen"
include("app-todo-rest")
include("app-web")
