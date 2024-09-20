package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.outlined.Timeline
import androidx.compose.ui.graphics.vector.ImageVector
import jp.yuyuyu.common.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val titleTextId: Int
) {
    HOME(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        titleTextId = R.string.home_tab
    ),
    TIMELINE(
        selectedIcon = Icons.Default.Timeline,
        unselectedIcon = Icons.Outlined.Timeline,
        titleTextId = R.string.time_line_tab
    ),
    SETTING(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        titleTextId = R.string.setting_tab
    )
}
