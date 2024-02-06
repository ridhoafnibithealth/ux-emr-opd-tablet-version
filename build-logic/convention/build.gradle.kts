import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}
group = "com.siloam.opd.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin{
    plugins{
        register("androidApplication") {
            id = "siloam.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "siloam.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "siloam.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "siloam.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeatureCompose") {
            id = "siloam.android.feature.compose"
            implementationClass = "AndroidFeatureComposeConventionPlugin"
        }

        register("androidRoom") {
            id = "siloam.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidHilt") {
            id = "siloam.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidFirebase") {
            id = "siloam.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }

        register("androidRetrofit") {
            id = "siloam.android.retrofit"
            implementationClass = "AndroidRetrofitConventionPlugin"
        }

        register("jvmLibrary") {
            id = "siloam.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}