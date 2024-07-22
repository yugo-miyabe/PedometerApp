package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.pedometerapp.AppNavHost

@Composable
fun PedometerApp(modifier: Modifier = Modifier) {
    PedometerAppTheme {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                TopLevelDestination.entries.forEach {
                    item(
                        icon = {
                            Icon(
                                imageVector = it.selectedIcon,
                                contentDescription = null,
                            )
                        },
                        label = { Text(text = stringResource(id = it.titleTextId)) },
                        selected = true,
                        onClick = { }
                    )
                }
            }
        ) {
            Surface(
                modifier = modifier.fillMaxSize(),
            ) {
                AppNavHost()
            }
        }
    }
}