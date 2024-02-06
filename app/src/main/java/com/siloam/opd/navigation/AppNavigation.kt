package com.siloam.opd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.siloam.opd.profile.navigateToProfileScreen
import com.siloam.opd.profile.profileScreen
import com.siloam.opd.repolist.repoListScreen
import com.siloam.opd.repolist.repoListScreenRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = repoListScreenRoute
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        repoListScreen(onRepoItemClick = navController::navigateToProfileScreen)
        profileScreen(onBackBtnClick = navController::popBackStack)
    }
}