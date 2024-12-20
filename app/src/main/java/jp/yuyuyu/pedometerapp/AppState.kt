package jp.yuyuyu.pedometerapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import jp.yuyuyu.home.navigation.navigateToHomeScreen
import jp.yuyuyu.setting.navigation.navigateToSettingScreen
import jp.yuyuyu.timeline.navigation.navigateToTimeLineScreen

@Stable
class AppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: PedometerBottomNavigation) {
        trace(sectionName = "Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                PedometerBottomNavigation.HOME ->
                    navController.navigateToHomeScreen(topLevelNavOptions)

                PedometerBottomNavigation.TIMELINE ->
                    navController.navigateToTimeLineScreen(topLevelNavOptions)

                PedometerBottomNavigation.SETTING ->
                    navController.navigateToSettingScreen(topLevelNavOptions)
            }
        }
    }
}
