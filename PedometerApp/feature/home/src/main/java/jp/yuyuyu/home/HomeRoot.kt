package jp.yuyuyu.home

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import jp.yuyuyu.ui.content.HomeContent

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val permissionLaunch =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            // TODO
            Log.d("tag", isGranted.toString())
        }

    HomeContent()

    LaunchedEffect(Unit) {
        permissionLaunch.launch(Manifest.permission.ACTIVITY_RECOGNITION)
    }
}
