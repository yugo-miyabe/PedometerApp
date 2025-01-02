package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.home.navigation.navigateToHome
import jp.yuyuyu.setting.navigation.navigationToSetting
import jp.yuyuyu.setting.navigation.settingNavGraph
import jp.yuyuyu.tutorial.navigation.TutorialRoute
import jp.yuyuyu.tutorial.navigation.tutorialNavGraph

@Composable
fun PedometerNavHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TutorialRoute,
    ) {
        tutorialNavGraph(
            onNext = {
                navController.navigateToHome(builder = {
                    popUpTo(TutorialRoute) { inclusive = true }
                })
            }
        )
        homeNavGraph(
            navController = navController,
            navigationToSetting = {
                navController.navigationToSetting()
            }
        )
        // timeLineNavGraph()
        settingNavGraph(navController = navController)
    }
}
