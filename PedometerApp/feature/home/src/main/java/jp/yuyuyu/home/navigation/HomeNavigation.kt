package jp.yuyuyu.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> { backStackEntry ->
            HomeScreen()
        }
    }
}
