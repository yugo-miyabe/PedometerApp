package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.home.navigation.HomeNavHost
import jp.yuyuyu.setting.navigation.SettingNavHost

@Composable
fun PedometerApp(modifier: Modifier = Modifier) {
    PedometerAppTheme {
        var currentDestination by rememberSaveable { mutableStateOf(TopLevelDestination.HOME) }

        NavigationSuiteScaffold(
            navigationSuiteItems = {
                TopLevelDestination.entries.forEach { topLevelDestination ->
                    item(
                        icon = {
                            Icon(
                                imageVector = topLevelDestination.selectedIcon,
                                contentDescription = null,
                            )
                        },
                        label = { Text(text = stringResource(id = topLevelDestination.titleTextId)) },
                        selected = topLevelDestination == currentDestination,
                        onClick = {
                            currentDestination = topLevelDestination
                        }
                    )
                }
            }
        ) {
            when (currentDestination) {
                TopLevelDestination.HOME -> {
                    HomeNavHost(
                        navController = rememberNavController(),
                    )
                }

                TopLevelDestination.SETTING -> {
                    SettingNavHost(
                        navController = rememberNavController(),
                    )
                }
            }
        }
    }
}