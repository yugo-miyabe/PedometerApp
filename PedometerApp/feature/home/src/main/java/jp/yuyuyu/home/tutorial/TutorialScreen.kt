package jp.yuyuyu.home.tutorial

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.template.TutorialTemplate

@Composable
fun TutorialScreen(
    viewModel: TutorialViewModel = hiltViewModel()
) {
    TutorialTemplate()
}

