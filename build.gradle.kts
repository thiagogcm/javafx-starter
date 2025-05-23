buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:3.4.5")
    }
}

plugins {
    java
    checkstyle
    id("org.openjfx.javafxplugin") version "0.1.0"
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

checkstyle {
    toolVersion = "10.17.0"
}

javafx {
    version = "17.0.10"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics")
}

dependencies {
    // Rx
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("com.github.ReactiveX:RxJavaFX:2.11.0-RC36")

    // Spring Boot libraries
    implementation("org.springframework.boot:spring-boot-starter:3.4.5") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.4.5")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.5")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.testfx:testfx-core:4.0.18")
    testImplementation("org.testfx:testfx-junit5:4.0.18")
}

java {
    group = "io.github.thiagogcm.javafxstarter"
    version = "1.0"

        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "8.14"
    }
}
