package jp.yuyuyu.pedometerapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.yuyuyu.home.navigation.HomeRoute
import jp.yuyuyu.home.navigation.homeNavGraph
import jp.yuyuyu.pedometerapp.PedometerNavigationBottomBar
import jp.yuyuyu.setting.navigation.settingGraph
import jp.yuyuyu.timeline.navigation.timeLineGraph
import kotlinx.serialization.Serializable

@Serializable
data object AppRoute

fun NavGraphBuilder.navigationRootNavGraph(navController: NavHostController) {
    composable<AppRoute> {
        NavigationBottomRootPage()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationBottomRootPage() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            PedometerNavigationBottomBar(navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            homeNavGraph()
            timeLineGraph()
            settingGraph()
        }
    }
}
