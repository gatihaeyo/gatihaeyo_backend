import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.kapt") version "1.7.10"
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {

    // aws
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
    implementation("com.amazonaws:aws-java-sdk-ses:1.12.307")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation:2.7.5")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis:2.7.5")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // openfeign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.5")

    // db
    runtimeOnly("mysql:mysql-connector-java")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    // configuration
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "ignore")
    }
}

allOpen {
    annotation("com.project.gatihaeyo.global.annotation.BusinessService")
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
