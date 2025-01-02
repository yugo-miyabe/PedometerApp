package jp.yuyuyu.ui.template

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.ui.organisms.StepCount
import jp.yuyuyu.ui.organisms.TopBar
import jp.yuyuyu.ui.theme.PedometerAppTheme
import jp.yuyuyu.ui.util.extension.toCommaSeparated

@Composable
fun HomeTemplate(
    todayStep: Int,
    onSettingClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                actions = {
                    IconButton(onClick = onSettingClick) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        val insetsPadding =
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
            ).asPaddingValues()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = insetsPadding
        ) {
            item {
                Spacer(Modifier.height(20.dp))
                StepCount(stepCount = todayStep.toCommaSeparated())
                Spacer(Modifier.height(20.dp))
            }
            item {
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
            }
            item {
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
            }
            item {
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
                Text(modifier = Modifier.height(150.dp), text = "Home_2")
            }
            item {
                Button(onClick = onSettingClick) {
                    Text(text = "Button")
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomePreview() {
    PedometerAppTheme {
        Surface {
            HomeTemplate(
                todayStep = 150000,
                onSettingClick = {/* preview */ }
            )
        }
    }
}
