package jp.yuyuyu.setting

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.template.SettingContent

@Composable
fun SettingScreen(
    viewModel: SettingViewModel = hiltViewModel(),
) {
    SettingContent()
}
