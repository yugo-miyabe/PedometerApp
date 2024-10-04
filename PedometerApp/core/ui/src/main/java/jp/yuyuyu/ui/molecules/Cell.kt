package jp.yuyuyu.ui.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.util.PreviewDynamicTheme

@Composable
fun ListItem(text: String, onClicked: () -> Unit) {
    Card(onClick = onClicked) {
        Box(modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()) {
            Text(text)
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun ListItemPreview() {
    PedometerAppTheme {
        Surface {
            ListItem(text = "データとアクセス権限の管理", onClicked = { /* preview */ })
        }
    }
}
