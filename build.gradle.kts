import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    application
}

group = "me.ditz.codeclubbot"
version = "1.0.0"

description = "The discord bot for the CodeClub Community."


java {
    sourceCompatibility = VERSION_1_8
}

// Javacord is on Maven central
repositories {
    mavenCentral()
}

// The dependencies of the bot. Javacord and Log4J for logging
dependencies {
    implementation("org.javacord:javacord:3.3.2")
    implementation("org.apache.logging.log4j:log4j-api:2.17.0")
    runtimeOnly("org.apache.logging.log4j:log4j-to-slf4j:2.17.0")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.8")
    implementation("io.github.cdimascio:dotenv-java:2.2.3")
}

application {
    mainClass.set("me.ditz.codeclubbot.Main")
}
