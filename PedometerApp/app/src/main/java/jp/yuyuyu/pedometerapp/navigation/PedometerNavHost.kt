package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import jp.yuyuyu.home.navigation.HomeRoute
import jp.yuyuyu.home.navigation.homeScreen
import jp.yuyuyu.pedometerapp.AppState
import jp.yuyuyu.setting.navigation.settingScreen
import jp.yuyuyu.timeline.navigation.timeLineScreen

@Composable
fun PedometerNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        homeScreen()
        timeLineScreen()
        settingScreen()
    }
}
