@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.siloam.android.feature.compose)
}
android {
    namespace = "com.siloam.opd.profile"
}

dependencies{
    implementation(libs.image.coil.compose)
}