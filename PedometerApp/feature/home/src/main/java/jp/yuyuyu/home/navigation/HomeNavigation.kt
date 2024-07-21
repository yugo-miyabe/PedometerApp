package jp.yuyuyu.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import jp.yuyuyu.home.HomeScreen

fun NavGraphBuilder.homeNavigation() {
    composable(
        route = HomeRoutes.Home.route
    ) { backStackEntry -> // backStackEntry パラメータを追加
        HomeScreen()
    }
}

interface HomeRoutes {
    val route: String

    data object Home : HomeRoutes {
        override val route: String = "home_top"
    }
}
