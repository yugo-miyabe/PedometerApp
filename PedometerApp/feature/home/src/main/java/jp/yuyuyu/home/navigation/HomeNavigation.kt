package jp.yuyuyu.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import jp.yuyuyu.home.HomeScreen
import jp.yuyuyu.home.tutorial.TutorialScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object TutorialRoute

fun NavController.navigateToHomeScreen(navOptions: NavOptions) {
    navigate(route = HomeRoute, navOptions)
}

fun NavController.navigateToTutorialScreen() {
    navigate(route = TutorialRoute)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    composable<HomeRoute> {
        HomeScreen(onNavigateToTutorial = navController::navigateToTutorialScreen)
    }

    composable<TutorialRoute> {
        TutorialScreen()
    }
}
