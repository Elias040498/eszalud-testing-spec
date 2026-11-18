plugins {
    id("java")
}

group = "pe.saludpublica"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.0")
    testImplementation("org.mockito:mockito-core:5.14.0")
}

tasks.test {
    useJUnitPlatform()
}
