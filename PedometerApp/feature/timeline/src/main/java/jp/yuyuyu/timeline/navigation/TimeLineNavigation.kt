package jp.yuyuyu.timeline.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.timeline.TimeLineScreen
import kotlinx.serialization.Serializable

@Serializable
private data object TimeLine

@Composable
fun TimeLineNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = TimeLine
    ) {
        composable<TimeLine> {
            TimeLineScreen()
        }
    }
}
