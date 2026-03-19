val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version = "1.1.1"

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.ktor.plugin") version "3.4.1"
}

group = "dev.davidbuitrago"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    // Ktor Server Core & Netty
    implementation("io.ktor:ktor-server-core-jvm:3.4.1")
    implementation("io.ktor:ktor-server-netty-jvm:3.4.1")

    // Serialization (Replacing ktor-jackson)
    implementation("io.ktor:ktor-server-content-negotiation-jvm:3.4.1")
    implementation("io.ktor:ktor-serialization-jackson-jvm:3.4.1")

    // Authentication (Replacing ktor-auth)
    implementation("io.ktor:ktor-server-auth-jvm:3.4.1")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:3.4.1")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")

    // Database & Connection Pool
    implementation("org.postgresql:postgresql:42.7.10")
    implementation("com.zaxxer:HikariCP:7.0.2")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.32")
}
