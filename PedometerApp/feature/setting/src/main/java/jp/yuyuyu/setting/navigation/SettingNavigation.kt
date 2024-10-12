package jp.yuyuyu.setting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.setting.SettingScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingRoute

fun NavController.navigateToSettingScreen(navOptions: NavOptions) {
    navigate(route = SettingRoute, navOptions)
}

fun NavGraphBuilder.settingNavGraph() {
    composable("setting_route") {
        SettingScreen()
    }
}

@Composable
fun SettingNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SettingRoute) {
        composable<SettingRoute> {
            SettingScreen()
        }
    }
}
