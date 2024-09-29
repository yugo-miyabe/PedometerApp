package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import jp.yuyuyu.pedometerapp.AppState
import jp.yuyuyu.pedometerapp.TopLevelDestination
import kotlin.reflect.KClass

@Composable
fun NavigationRootPage(
    appState: AppState,
) {
    val currentDestination = appState.currentDestination

    NavigationSuiteScaffold(navigationSuiteItems = {
        TopLevelDestination.entries.forEach { topLevelDestination ->
            item(
                selected = currentDestination.isRouteInHierarchy(topLevelDestination.route),
                icon = {
                    Icon(
                        imageVector = topLevelDestination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(text = stringResource(id = topLevelDestination.titleTextId)) },
                onClick = { appState.navigateToTopLevelDestination(topLevelDestination) },
            )
        }
    }, content = {
        PedometerNavHost(appState = appState)
    })
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) = this?.hierarchy?.any {
    it.hasRoute(route)
} ?: false
