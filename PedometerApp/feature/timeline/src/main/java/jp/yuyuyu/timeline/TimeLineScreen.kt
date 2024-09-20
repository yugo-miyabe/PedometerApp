package jp.yuyuyu.timeline

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.template.TimeLineTemplate

@Composable
fun TimeLineScreen(
    viewModel: TimeLineViewModel = hiltViewModel()
) {
    TimeLineTemplate()
}
