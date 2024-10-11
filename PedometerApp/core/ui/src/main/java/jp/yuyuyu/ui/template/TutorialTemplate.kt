package jp.yuyuyu.ui.template

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.atoms.BottomButton
import jp.yuyuyu.ui.util.PreviewDynamicTheme

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
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onNext,
                        content = { Text("次へ") }
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
                .padding(innerPadding),
            contentPadding = insetsPadding
        ) {
            item {
                Text(text = "Tutorial_1")
            }
            item {
                Text(text = "Tutorial_2")
            }
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun TutorialPreview() {
    PedometerAppTheme {
        Surface {
            TutorialTemplate()
        }
    }
}
