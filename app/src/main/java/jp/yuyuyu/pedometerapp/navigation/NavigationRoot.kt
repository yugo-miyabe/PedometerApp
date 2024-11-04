package jp.yuyuyu.pedometerapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.pedometerapp.PedometerBottomNavigation
import jp.yuyuyu.setting.navigation.settingNavGraph
import jp.yuyuyu.timeline.navigation.timeLineNavGraph
import kotlinx.serialization.Serializable

@Serializable
data object BottomNavigationRoute

fun NavGraphBuilder.navigationRootNavGraph() {
    composable<BottomNavigationRoute> {
        NavigationBottomRootPage()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationBottomRootPage() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                PedometerBottomNavigation.entries.forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                item.selectedIcon,
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(item.titleTextId)) },
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(route = item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        BottomNavigationRoot(navController = navController)
    }
}

@Composable
fun BottomNavigationRoot(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PedometerBottomNavigation.HOME.route
    ) {
        homeNavGraph()
        timeLineNavGraph()
        settingNavGraph()
    }
}
