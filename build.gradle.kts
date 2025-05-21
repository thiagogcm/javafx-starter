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
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

checkstyle {
    toolVersion = "8.2"
}

dependencies {
    // Rx
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("io.reactivex.rxjava3:rxjavafx:2.11.0-RC36")

    // Spring Boot libraries
    implementation("org.springframework.boot:spring-boot-starter:3.4.5") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.4.5")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.5")
    testImplementation("org.testfx:testfx-core:4.0.18")
    testImplementation("org.testfx:testfx-junit5:4.0.18")
}

java {
    group = "io.github.thiagogcm.javafxstarter"
    version = "1.0"

        sourceCompatibility = JavaVersion.VERSION_1_17
        targetCompatibility = JavaVersion.VERSION_1_17
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "8.14"
    }
}
