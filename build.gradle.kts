plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

group = "com.demo"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

allprojects {
	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
	}

	group = "com.demo"
	version = "0.0.1-SNAPSHOT"

	subprojects {
		apply(plugin = "java")
		apply(plugin = "org.springframework.boot")
		apply(plugin = "io.spring.dependency-management")

		dependencies {
			implementation("org.springframework.boot:spring-boot-starter-web")
			implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
			implementation("org.springframework.boot:spring-boot-starter-actuator")
			implementation("org.springframework.boot:spring-boot-starter-data-jpa")
			implementation("org.springframework.boot:spring-boot-starter-validation")

			annotationProcessor("org.projectlombok:lombok")

			testImplementation("org.springframework.boot:spring-boot-starter-test")
			testRuntimeOnly("org.junit.platform:junit-platform-launcher")
			runtimeOnly("com.h2database:h2")
		}
	}
}

project(":") {
	apply(plugin = "org.springframework.boot")
	springBoot {
		mainClass = "com.demo.db_secure.Main"
	}
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-validation")
		developmentOnly("org.springframework.boot:spring-boot-devtools")

		annotationProcessor("org.projectlombok:lombok")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
		implementation(project(":product-service"))
		implementation(project(":user-service"))
		implementation(project(":audit-service"))
		runtimeOnly("com.h2database:h2")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
