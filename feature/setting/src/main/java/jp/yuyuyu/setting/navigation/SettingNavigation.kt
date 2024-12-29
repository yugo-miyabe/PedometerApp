package jp.yuyuyu.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import jp.yuyuyu.setting.SettingScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingRoute

fun NavGraphBuilder.settingNavGraph(navController: NavController) {
    composable<SettingRoute> {
        SettingScreen()
    }
}

fun NavController.navigationToSetting(
    builder: (NavOptionsBuilder.() -> Unit)? = null,
) = navigate(
    route = SettingRoute,
    navOptions = builder?.let(::navOptions)
)
