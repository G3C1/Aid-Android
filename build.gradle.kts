buildscript {
    dependencies {
        classpath(Dependency.GradlePlugin.GRADLE_HILT)
        classpath(Dependency.Google.GMS_GOOGLE_SERVICE)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependency.GradlePlugin.GRADLE_ANDROID_APPLICATION) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.GRADLE_ANDROID_LIBRARY) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.GRADLE_KOTLIN) version Versions.GRADLE_KOTLIN apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}