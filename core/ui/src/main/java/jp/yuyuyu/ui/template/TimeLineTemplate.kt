package jp.yuyuyu.ui.template

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
fun TimeLineTemplate() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
                Text(text = "TimeLine_1")
            }
            item {
                Text(text = "TimeLine_2")
            }
            item {
                Text(text = "TimeLine_3")
            }
            item {
                Text(text = "TimeLine_4")
            }
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun HomePreview() {
    PedometerAppTheme {
        Surface {
            TimeLineTemplate()
        }
    }
}
