package jp.yuyuyu.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.StepsRecord
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import jp.yuyuyu.ui.template.HomeTemplate
import org.orbitmvi.orbit.compose.collectSideEffect
import timber.log.Timber

@Composable
fun HomeScreen(
    onNavigateToTutorial: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    val healthPermission =
        setOf(
            HealthPermission.getReadPermission(StepsRecord::class),
            HealthPermission.getWritePermission(StepsRecord::class),
        )

    val requestPermissionActivityContract =
        PermissionController.createRequestPermissionResultContract()

    @Suppress("UnusedPrivateProperty")
    val requestHealthPermissions =
        rememberLauncherForActivityResult(requestPermissionActivityContract) { granted ->
            if (granted.containsAll(healthPermission)) {
                // 全ての権限が許可されたケース
                Timber.d("all permission granted")
            } else {
                // 許可されていない権限があるケース
                Timber.d("all not granted")
            }
        }

    viewModel.collectSideEffect {
        when (it) {
            HomeSideEffect.RequestStepData -> {

            }
        }
    }

    HomeTemplate(
        todayStep = state.todayStep,
        onClick = {
            /*
            // Health Connect Client のインスタンスを取得
            val healthConnectClient = HealthConnectClient.getOrCreate(context)
            // 歩数データを読み取り
            viewModel.requestRecode(healthConnectClient)
            */
            onNavigateToTutorial()
        }
    )
}
