plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

dependencies {
    implementation(project(":gatihaeyo-domain"))

    implementation(Dependencies.SPRING_TRANSACTION)

    implementation(Dependencies.SPRING_WEB)
}

allOpen {
    annotation("com.project.gatihaeyo.global.annotation.BusinessService")
    annotation("com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService")
}
