package jp.yuyuyu.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import jp.yuyuyu.setting.SettingScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingRoute

fun NavController.navigateToSettingScreen(navOptions: NavOptions) {
    navigate(route = SettingRoute, navOptions)
}

fun NavGraphBuilder.settingScreen() {
    composable<SettingRoute>() {
        SettingScreen()
    }
}
