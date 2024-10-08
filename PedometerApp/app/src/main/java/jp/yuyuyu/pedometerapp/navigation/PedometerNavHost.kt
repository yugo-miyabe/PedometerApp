package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.pedometerapp.AppState
import jp.yuyuyu.setting.navigation.settingScreen
import jp.yuyuyu.timeline.navigation.timeLineScreen
import jp.yuyuyu.tutorial.navigation.TutorialRoute
import jp.yuyuyu.tutorial.navigation.tutorialNavGraph

@Composable
fun PedometerNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = TutorialRoute,
        modifier = modifier
    ) {
        tutorialNavGraph()

        homeNavGraph(navController)
        timeLineScreen()
        settingScreen()
    }
}
