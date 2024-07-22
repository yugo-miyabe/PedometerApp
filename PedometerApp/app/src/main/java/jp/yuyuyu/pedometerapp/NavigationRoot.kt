package jp.yuyuyu.pedometerapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.HomeRoutes
import jp.yuyuyu.home.navigation.homeNavigation
import jp.yuyuyu.setting.navigation.settingNavigation

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoutes.Home.route,
    ) {
        homeNavigation()

        settingNavigation()
    }
}

enum class Screen(val rootName: String) {
    HOME_ROUTE(rootName = "home_top"),
    SETTING_ROUTE(rootName = "setting")
}