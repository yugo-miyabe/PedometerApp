package jp.yuyuyu.home

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.util.PreviewDynamicTheme

@Composable
fun HomeScreen() {
    val permissionLaunch =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Log.d("tag", isGranted.toString())
            } else {
                Log.d("tag", isGranted.toString())
            }
        }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val insetsPadding =
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
            ).asPaddingValues()

        permissionLaunch.launch(Manifest.permission.ACTIVITY_RECOGNITION)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = insetsPadding
        ) {
            item {
                Text(text = "Home_1")
            }
            item {
                Text(text = "Home_2")
            }
            item {
                Text(text = "Home_3")
            }
            item {
                Text(text = "Home_4")
            }
            item {
                Text(text = "Home_5")
            }
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun HomePreview() {
    PedometerAppTheme {
        Surface {
            HomeScreen()
        }
    }
}
