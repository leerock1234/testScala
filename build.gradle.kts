plugins {
    scala
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {name = "ali-central"; url= uri("https://maven.aliyun.com/repository/central")};
    maven {name = "ali-jcenter"; url= uri("https://maven.aliyun.com/repository/public")};
    maven {name = "ali-public"; url = uri("https://maven.aliyun.com/repository/public")}
    maven {name = "ali-google"; url = uri("https://maven.aliyun.com/repository/google")}
    maven {name = "ali-gradle-plugin"; url = uri("https://maven.aliyun.com/repository/gradle-plugin")}
    maven {name = "ali-spring"; url = uri("https://maven.aliyun.com/repository/spring")}
    maven {name = "ali-spring-plugin"; url = uri("https://maven.aliyun.com/repository/spring-plugin")}
    maven {name = "ali-grails-core"; url = uri("https://maven.aliyun.com/repository/grails-core")}
    maven {name = "ali-apache-snapshots"; url = uri("https://maven.aliyun.com/repository/apache-snapshots")}
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.17")
    implementation("org.scala-lang:scala-compiler:2.12.17")

    implementation("org.eclipse.jetty:jetty-server:11.0.13")
    implementation("org.eclipse.jetty:jetty-servlet:11.0.13")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")


    testImplementation("org.scalatest:scalatest_2.12:3.2.15")
    testImplementation("org.scalatestplus:scalatestplus-junit_2.12:1.0.0-M2")
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.scala-lang.modules:scala-xml_2.12:2.1.0")
}
