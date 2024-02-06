@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.siloam.android.library)
    alias(libs.plugins.siloam.android.hilt)
}

android {
    namespace = "com.siloam.opd.domain"
}

dependencies {
    api(projects.model.entity)
    implementation(libs.androidx.corektx)
    implementation(libs.kotlinx.coroutines.android)
}