package jp.yuyuyu.tutorial

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.template.TutorialTemplate
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun TutorialPage(
    onNext: () -> Unit,
    viewModel: TutorialViewModel = hiltViewModel()
) {

    val permissionLaunch =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                onNext()
            } else {
                onNext()
            }
        }

    viewModel.collectSideEffect {
        when (it) {
            TutorialSideEffect.RequestPermission -> {
                permissionLaunch.launch(android.Manifest.permission.ACTIVITY_RECOGNITION)
            }
        }
    }

    TutorialTemplate(onNext = viewModel::onNext)
}
