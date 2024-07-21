package jp.yuyuyu.pedometerapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraphBuilder.navigationRootNavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HOME_ROUTE.rootName,
        modifier = modifier
    ) {

    }

}

enum class Screen(val rootName: String) {
    HOME_ROUTE(rootName = "home"),
    SETTING_ROUTE(rootName = "setting")
}