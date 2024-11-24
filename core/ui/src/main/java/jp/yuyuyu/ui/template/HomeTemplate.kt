package jp.yuyuyu.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.organisms.AnimatedCircle
import jp.yuyuyu.ui.util.PreviewDynamicTheme

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

        val accountsProportion: List<Float> = listOf(
            0.025059527f,
            0.66295046f,
            0.04824622f,
            0.042760305f,
        )
        val circleColors: List<Color> = listOf(
            Color(0xFF004940),
            Color(0xFF005D57),
            Color(0xFF04B97F),
            Color(0xFF37EFBA)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = insetsPadding
        ) {
            item {
                Box(Modifier.padding(16.dp)) {
                    AnimatedCircle(
                        proportions = accountsProportion,
                        colors = circleColors,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                    )
                }
            }
            item {
                Text(text = "歩いた歩数: $todayStep")
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

@PreviewDynamicTheme
@Composable
fun HomePreview() {
    PedometerAppTheme {
        Surface {
            HomeTemplate(
                todayStep = 100,
                onClick = {/* preview */ }
            )
        }
    }
}
