package jp.yuyuyu.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToHomeScreen(navOptions: NavOptions) {
    navigate(route = HomeRoute, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
) {
    composable<HomeRoute> {
        HomeScreen(onNavigateToTutorial = {
            // TODO tutorialへ遷移する
        })
    }
}


@Composable
fun HomeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(onNavigateToTutorial = {
                // TODO tutorialへ遷移する
            })
        }
    }
}
