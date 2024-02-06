package com.siloam.opd

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.siloam.opd.designsystem.theme.SiloamOpdTabletVersionTheme
import com.siloam.opd.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiloamOpdTabletVersionTheme {
                val navController = rememberNavController()
                val notifPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

                PermissionScreen(
                    permissinStatus = notifPermission.status
                ) { notifPermission.launchPermissionRequest() }

                SideEffect {
                    notifPermission.launchPermissionRequest()
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(
                        navController = navController
                    )
                }
            }
        }
    }
}
