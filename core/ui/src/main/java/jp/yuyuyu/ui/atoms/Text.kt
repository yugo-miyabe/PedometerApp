package jp.yuyuyu.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle,
) = androidx.compose.material3.Text(
    text = text,
    modifier = modifier,
    style = style
)
