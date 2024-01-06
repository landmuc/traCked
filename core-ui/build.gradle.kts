plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.landmuc.core_ui"
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.questionnaireDomain))
}