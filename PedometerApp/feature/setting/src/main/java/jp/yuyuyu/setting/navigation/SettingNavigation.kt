package jp.yuyuyu.setting.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import jp.yuyuyu.setting.SettingScreen

fun NavGraphBuilder.settingNavigation() {
    composable(
        route = SettingRoutes.Home.route
    ) { backStackEntry -> 
        SettingScreen()
    }
}

interface SettingRoutes {
    val route: String

    data object Home : SettingRoutes {
        override val route: String = "setting_top"
    }
}
