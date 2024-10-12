package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.pedometerapp.AppState
import kotlin.reflect.KClass

@Composable
fun NavigationRootPage() {
    val navController = rememberNavController()
    val appState = AppState(navController = navController)
    val currentDestination = appState.currentDestination

    PedometerNavHost()
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) = this?.hierarchy?.any {
    it.hasRoute(route)
} ?: false
