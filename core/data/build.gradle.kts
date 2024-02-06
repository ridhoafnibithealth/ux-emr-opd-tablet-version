@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.siloam.android.library)
    alias(libs.plugins.siloam.android.hilt)
}
android {
    namespace = "com.siloam.opd.data"

}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.di)
    api(projects.model.apiresponse)
}