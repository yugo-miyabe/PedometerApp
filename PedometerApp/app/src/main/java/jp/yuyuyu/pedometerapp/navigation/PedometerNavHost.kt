package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import jp.yuyuyu.tutorial.navigation.TutorialRoute
import jp.yuyuyu.tutorial.navigation.tutorialNavGraph

@Composable
fun PedometerNavHost() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = TutorialRoute,
        modifier = Modifier
    ) {
        tutorialNavGraph(
            onNext = {
                navController.navigate(
                    route = BottomNavigationRoute,
                    navOptions = navOptions {
                        popUpTo(TutorialRoute) { inclusive = true }
                    }
                )
            }
        )
        navigationRootNavGraph()
    }
}
