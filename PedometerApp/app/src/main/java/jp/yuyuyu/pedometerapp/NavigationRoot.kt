package jp.yuyuyu.pedometerapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.HomeRoutes
import jp.yuyuyu.home.navigation.homeNavigation
import jp.yuyuyu.pedometerapp.ui.theme.PedometerAppTheme
import jp.yuyuyu.setting.navigation.settingNavigation

@Composable
fun PedometerApp(modifier: Modifier = Modifier) {
    PedometerAppTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
        ) {
            AppNavHost()
        }
    }
}


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