plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

dependencies {
    implementation(project(":gatihaeyo-domain"))
    implementation(project(":gatihaeyo-application"))
    implementation(project(":gatihaeyo-presentation"))

    // kotlin
    implementation(Dependencies.JACKSON)

    // validation
    implementation(Dependencies.SPRING_VALIDATION)

    // security
    implementation(Dependencies.SPRING_SECURITY)

    //jwt
    implementation(Dependencies.JWT)

    // database
    implementation(Dependencies.SPRING_DATA_JPA)
    runtimeOnly(Dependencies.MYSQL_CONNECTOR)
    implementation(Dependencies.REDIS)
    implementation(Dependencies.SPRING_REDIS)

    // querydsl
    implementation(Dependencies.QUERYDSL)
    kapt(Dependencies.QUERYDSL_PROCESSOR)

    // aws
    implementation(Dependencies.SPRING_AWS)
    implementation(Dependencies.AWS_SES)

    // mapstruct
    implementation(Dependencies.MAPSTRUCT)
    kapt(Dependencies.MAPSTRUCT_PROCESSOR)

    // openfeign
    implementation(Dependencies.OPEN_FEIGN)

    // configuration
    annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)

}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "ignore")
    }
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}
