package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object AppRoute

fun NavGraphBuilder.navigationRootNavGraph(navController: NavHostController) {
    // val appState = AppState(navController = navController)

    composable<AppRoute> {
        NavigationBottomRootPage()
    }

    /*
    homeNavGraph(navController)
    timeLineScreen()
    settingScreen()
     */
}

@Composable
fun NavigationBottomRootPage() {
    NavigationBottomRootTemplate()
}

@Composable
fun NavigationBottomRootTemplate() {
    // TODO
}
