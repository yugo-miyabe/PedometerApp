package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.setting.navigation.settingScreen
import jp.yuyuyu.timeline.navigation.timeLineScreen
import jp.yuyuyu.tutorial.navigation.TutorialRoute
import jp.yuyuyu.tutorial.navigation.tutorialNavGraph

@Composable
fun PedometerNavHost(
    navController: NavHostController = rememberNavController(),
) {
    // val navController = appState.navController
    // val navController: NavController = rememberNavController(),

    NavHost(
        navController = navController,
        startDestination = TutorialRoute,
        modifier = Modifier
    ) {
        tutorialNavGraph()

        homeNavGraph(navController)
        timeLineScreen()
        settingScreen()
    }
}
