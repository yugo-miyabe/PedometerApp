package jp.yuyuyu.tutorial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import jp.yuyuyu.tutorial.TutorialScreen
import kotlinx.serialization.Serializable

@Serializable
data object TutorialRoute

fun NavController.navigateToTutorialScreen() {
    navigate(route = TutorialRoute)
}

fun NavGraphBuilder.tutorialNavGraph(
    navController: NavController
) {
    composable<TutorialRoute> {
        TutorialScreen()
    }
}
