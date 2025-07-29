plugins {
    id("java")
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