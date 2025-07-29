plugins {
    java
}

tasks.bootJar {
    enabled = false
}

tasks.bootRun {
    enabled = false
}

tasks.jar {
    enabled = true
}

dependencies {
    implementation(project(":audit-service"))
}