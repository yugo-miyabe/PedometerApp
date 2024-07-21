package jp.yuyuyu.pedometerapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.homeNavigation

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HOME_ROUTE.rootName,
        modifier = modifier
    ) {
        homeNavigation()
    }

}

enum class Screen(val rootName: String) {
    HOME_ROUTE(rootName = "home"),
    SETTING_ROUTE(rootName = "setting")
}