package jp.yuyuyu.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.StepsRecord
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.content.HomeContent
import timber.log.Timber

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val permission =
        setOf(
            HealthPermission.getReadPermission(StepsRecord::class),
            HealthPermission.getWritePermission(StepsRecord::class),
        )

    val requestPermissionActivityContract =
        PermissionController.createRequestPermissionResultContract()
    val requestPermissions =
        rememberLauncherForActivityResult(requestPermissionActivityContract) { granted ->
            if (granted.containsAll(permission)) {
                // 全ての権限が許可されたケース
                Timber.d("all permission granted")
            } else {
                // 許可されていない権限があるケース
                Timber.d("all not granted")
            }
        }

    HomeContent()

    LaunchedEffect(Unit) {
        requestPermissions.launch(permission)
    }
}
