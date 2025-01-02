package jp.yuyuyu.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Left,
    style: TextStyle,
) = androidx.compose.material3.Text(
    text = text,
    textAlign = textAlign,
    modifier = modifier,
    style = style
)
