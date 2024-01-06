plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.landmuc.questionnaire_domain"
}

dependencies {
    implementation(project(Modules.core))
}