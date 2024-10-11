package jp.yuyuyu.pedometerapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.ui.util.PreviewDynamicTheme

@Composable
fun PedometerNavigationBottomBar(
    navController: NavHostController,
    selectedItem: TopLevelDestination = TopLevelDestination.HOME
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        for (item in TopLevelDestination.entries) {
            val selected = item == selectedItem
            NavigationBarItem(
                selected = selected,
                label = { Text(item.name) },
                icon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = item.name
                    )
                },
                onClick = {
                    navController.navigate(item.route)
                },
            )
        }
    }
}

@PreviewDynamicTheme
@Composable
fun PedometerNavigationBottomBarPreview() {
    val navController = rememberNavController()
    PedometerNavigationBottomBar(navController)
}
