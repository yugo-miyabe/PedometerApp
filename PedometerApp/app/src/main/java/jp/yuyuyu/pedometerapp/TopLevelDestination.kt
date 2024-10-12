package jp.yuyuyu.pedometerapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.graphics.vector.ImageVector
import jp.yuyuyu.common.R
import kotlinx.serialization.Serializable

@Serializable
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val titleTextId: Int,
    val route: String
) {
    HOME(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        titleTextId = R.string.home_tab,
        route = "home_route"
    ),
    TIMELINE(
        selectedIcon = Icons.Default.Timeline,
        unselectedIcon = Icons.Default.Timeline,
        titleTextId = R.string.time_line_tab,
        route = "time_line_route"
    ),
    SETTING(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        titleTextId = R.string.setting_tab,
        route = "setting_route"
    )
}
