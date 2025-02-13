package jp.yuyuyu.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.common.R
import jp.yuyuyu.ui.atoms.Text
import jp.yuyuyu.ui.organisms.BottomButton
import jp.yuyuyu.ui.theme.PedometerAppTheme
import jp.yuyuyu.ui.theme.PedometerTypography

@Composable
fun TutorialTemplate(
    onNext: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomButton(
                content = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        onClick = onNext,
                        content = {
                            Text(
                                text = stringResource(R.string.tutorial_next),
                                style = PedometerTypography.labelLarge
                            )
                        }
                    )
                }
            )
        }
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
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = insetsPadding
        ) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(vertical = 100.dp),
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.DirectionsWalk),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp),
                    )
                }
            }
            item {
                Text(
                    text = "このアプリの使用するにはアクティビティの許可が必要です",
                    style = PedometerTypography.labelLarge
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun TutorialPreview() {
    PedometerAppTheme {
        Surface {
            TutorialTemplate(onNext = { /* preview */ })
        }
    }
}
