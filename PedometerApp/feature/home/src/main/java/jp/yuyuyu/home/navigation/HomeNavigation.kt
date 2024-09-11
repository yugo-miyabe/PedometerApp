package jp.yuyuyu.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.home.HomeScreen

@Composable
fun HomeNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoutes.Home.route,
    ) {
        composable(
            route = HomeRoutes.Home.route
        ) { backStackEntry ->
            HomeScreen()
        }
    }

}

fun NavGraphBuilder.homeNavigation() {
    composable(
        route = HomeRoutes.Home.route
    ) { backStackEntry ->
        HomeScreen()
    }
}

interface HomeRoutes {
    val route: String

    data object Home : HomeRoutes {
        override val route: String = "home_top"
    }
}
