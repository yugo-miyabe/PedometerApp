package jp.yuyuyu.timeline.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import jp.yuyuyu.timeline.TimeLineScreen
import kotlinx.serialization.Serializable

@Serializable
data object TimeLineRoute

fun NavController.navigateToTimeLineScreen(navOptions: NavOptions) {
    navigate(route = TimeLineRoute, navOptions)
}

fun NavGraphBuilder.timeLineScreen() {
    composable<TimeLineRoute>() {
        TimeLineScreen()
    }
}
