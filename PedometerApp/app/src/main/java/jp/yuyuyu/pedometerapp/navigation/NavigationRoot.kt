package jp.yuyuyu.pedometerapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.yuyuyu.home.navigation.HomeRoute
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.pedometerapp.PedometerNavigationBottomBar
import jp.yuyuyu.setting.navigation.settingScreen
import jp.yuyuyu.timeline.navigation.timeLineScreen
import kotlinx.serialization.Serializable

@Serializable
data object AppRoute

fun NavGraphBuilder.navigationRootNavGraph(navController: NavHostController) {
    // val appState = AppState(navController = navController)

    composable<AppRoute> {
        NavigationBottomRootPage(navController)
    }

    /*
    homeNavGraph(navController)
    timeLineScreen()
    settingScreen()
     */
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationBottomRootPage(navController: NavHostController) {
    Scaffold(
        bottomBar = { PedometerNavigationBottomBar(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            homeNavGraph(navController)
            timeLineScreen()
            settingScreen()
        }
    }
}

@Composable
fun NavigationBottomRootTemplate() {
    Text("hoge")
}
