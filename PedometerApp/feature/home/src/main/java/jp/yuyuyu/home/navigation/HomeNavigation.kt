package jp.yuyuyu.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
private data object HomeRoute

@Composable
fun HomeNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> { backStackEntry ->
            HomeScreen()
        }
    }
}
