package jp.yuyuyu.pedometerapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.graphics.vector.ImageVector
import jp.yuyuyu.common.R
import jp.yuyuyu.home.navigation.HomeRoute
import jp.yuyuyu.setting.navigation.SettingRoute
import jp.yuyuyu.timeline.navigation.TimeLineRoute
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val titleTextId: Int,
    val route: KClass<*>
) {
    HOME(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        titleTextId = R.string.home_tab,
        route = HomeRoute::class
    ),
    TIMELINE(
        selectedIcon = Icons.Default.Timeline,
        unselectedIcon = Icons.Default.Timeline,
        titleTextId = R.string.time_line_tab,
        route = TimeLineRoute::class
    ),
    SETTING(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        titleTextId = R.string.setting_tab,
        route = SettingRoute::class
    )
}
