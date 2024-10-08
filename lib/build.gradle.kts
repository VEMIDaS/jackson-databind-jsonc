/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.10.2/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "jp.vemi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:[2.9,2.18)")

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    api(libs.commons.math3)
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks {
    shadowJar {
        relocate("com.fasterxml.jackson", "shadow.com.fasterxml.jackson")
        archiveFileName.set("${project.name}-${project.version}.jar")  // JARファイル名を設定
        destinationDirectory.set(file("build/libs"))  // 出力ディレクトリを設定
    }
    named<Test>("test") {
        useJUnitPlatform()
    }
}
