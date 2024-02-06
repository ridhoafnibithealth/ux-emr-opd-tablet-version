@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.siloam.android.library)
    alias(libs.plugins.siloam.android.hilt)
    alias(libs.plugins.siloam.android.retrofit)
}
android {
    namespace = "com.siloam.opd.di"
}
dependencies {
    api(libs.log.timber)
    api(libs.bundles.network)
}
