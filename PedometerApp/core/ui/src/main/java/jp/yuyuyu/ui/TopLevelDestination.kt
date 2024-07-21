package jp.yuyuyu.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import jp.yuyuyu.common.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val titleTextId: Int
) {
    Home(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        titleTextId = R.string.home_tab
    ),
    Setting(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        titleTextId = R.string.setting_tab
    )
}
