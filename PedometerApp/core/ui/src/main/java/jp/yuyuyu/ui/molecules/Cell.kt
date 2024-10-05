package jp.yuyuyu.ui.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.util.PreviewDynamicTheme

@Composable
fun ListItem(
    text: String,
    modifier: Modifier = Modifier,
    isTop: Boolean = true,
    isBottom: Boolean = true,
    onClicked: () -> Unit
) {
    Card(
        onClick = onClicked, modifier = modifier,
        shape = RoundedCornerShape(
            topStart = if (isTop) 12.dp else 2.dp,
            topEnd = if (isTop) 12.dp else 2.dp,
            bottomEnd = if (isBottom) 12.dp else 2.dp,
            bottomStart = if (isBottom) 12.dp else 2.dp
        )
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text)
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun ListItemPreview() {
    PedometerAppTheme {
        Surface {
            Column {
                ListItem(text = "データとアクセス権限の管理", onClicked = { /* preview */ })
                Spacer(modifier = Modifier.height(16.dp))
                ListItem(
                    text = "利用規約",
                    isTop = true,
                    isBottom = false,
                    onClicked = { /* preview */ }
                )
                Spacer(modifier = Modifier.height(2.dp))
                ListItem(
                    text = "プライパシーポリシー",
                    isTop = false,
                    isBottom = true,
                    onClicked = { /* preview */ }
                )
            }
        }
    }
}
