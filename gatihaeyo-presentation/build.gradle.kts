plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
    implementation(project(":gatihaeyo-application"))

    implementation(Dependencies.SPRING_WEB)

    implementation(Dependencies.SPRING_VALIDATION)
}


tasks.getByName<Jar>("bootJar") {
    enabled = false
}
