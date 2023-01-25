import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "ca.kam.vmhardwarelibraries"
version = "1.0"

repositories {
    mavenCentral()
}



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

val jar: Jar by tasks

abstract class NoDependenciesJar: Jar()
tasks.register<NoDependenciesJar>("noDependenciesJar") {
    archiveBaseName.set("${project.name}-no-deps")
    with(jar)
}

abstract class FatJar: Jar()
tasks.register<FatJar>("fatJar") {
    val dependencies = configurations.runtimeClasspath
        .get()
        .map(::zipTree)

    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    with(jar)
}
