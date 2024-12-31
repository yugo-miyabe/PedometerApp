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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.ui.organisms.StepCount
import jp.yuyuyu.ui.theme.PedometerAppTheme

@Composable
fun HomeTemplate(
    todayStep: Int,
    onClick: () -> Unit
) {
    Scaffold(
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
                StepCount(stepCount = todayStep.toString())
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
                Button(onClick = onClick) {
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
                todayStep = 100,
                onClick = {/* preview */ }
            )
        }
    }
}
