package jp.yuyuyu.setting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.setting.SettingScreen
import kotlinx.serialization.Serializable

@Serializable
private data object Setting

@Composable
fun SettingNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Setting
    ) {
        composable<Setting> {
            SettingScreen()
        }
    }
}
