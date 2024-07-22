package jp.yuyuyu.setting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.setting.SettingScreen

@Composable
fun SettingNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SettingRoutes.Setting.route
    ) {
        composable(
            route = SettingRoutes.Setting.route
        ) {
            SettingScreen()
        }
    }
}

fun NavGraphBuilder.settingNavigation() {
    composable(
        route = SettingRoutes.Setting.route
    ) {
        SettingScreen()
    }
}

interface SettingRoutes {
    val route: String

    data object Setting : SettingRoutes {
        override val route: String = "setting_top"
    }
}
