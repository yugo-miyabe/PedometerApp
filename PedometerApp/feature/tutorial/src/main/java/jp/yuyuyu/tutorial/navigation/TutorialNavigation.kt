package jp.yuyuyu.tutorial.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import jp.yuyuyu.tutorial.TutorialPage
import kotlinx.serialization.Serializable

@Serializable
data object TutorialRoute

fun NavGraphBuilder.tutorialNavGraph(
    onNext: () -> Unit
) {

    composable<TutorialRoute> {
        TutorialPage(onNext = onNext)
    }
}
