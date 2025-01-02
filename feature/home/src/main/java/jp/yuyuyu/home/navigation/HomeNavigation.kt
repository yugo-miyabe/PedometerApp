package jp.yuyuyu.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import jp.yuyuyu.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeNavGraph(navController: NavController, navigationToSetting: () -> Unit) {
    composable<HomeRoute> {
        HomeScreen(
            onSettingClick = navigationToSetting
        )
    }
}

fun NavController.navigateToHome(
    builder: (NavOptionsBuilder.() -> Unit)? = null,
) = navigate(
    route = HomeRoute,
    navOptions = builder?.let(::navOptions)
)
