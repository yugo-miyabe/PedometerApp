package jp.yuyuyu.timeline.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.timeline.TimeLineScreen
import kotlinx.serialization.Serializable

@Serializable
data object TimeLineRoute

fun NavController.navigateToTimeLineScreen(navOptions: NavOptions) {
    navigate(route = TimeLineRoute, navOptions)
}

fun NavGraphBuilder.timeLineNavGraph() {
    composable("time_line_route") {
        TimeLineScreen()
    }
}

@Composable
fun TimeLineNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = TimeLineRoute) {
        composable<TimeLineRoute> {
            TimeLineScreen()
        }
    }
}

