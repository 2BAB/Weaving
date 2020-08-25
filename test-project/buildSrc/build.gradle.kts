plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven {
        setUrl("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "../../build/libs", "include" to arrayOf("*.jar"))))
    implementation(kotlin("stdlib"))
    implementation("com.android.tools.build:gradle:4.1.0-rc01")
    implementation("com.alibaba:fastjson:1.2.73")
//    implementation("me.2bab:polyfill:test-version")
}

task("cleanLibs") {
    delete("./libs")
}