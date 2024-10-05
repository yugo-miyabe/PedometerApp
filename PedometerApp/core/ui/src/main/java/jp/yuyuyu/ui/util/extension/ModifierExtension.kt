package jp.yuyuyu.ui.util.extension

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


fun Modifier.cardDecoration(
    isTop: Boolean,
    isBottom: Boolean,
): Modifier {
    val topRadius = if (isTop) 8.dp else 0.dp
    val bottomRadius = if (isBottom) 8.dp else 0.dp
    val clipShape =
        RoundedCornerShape(
            topStart = topRadius,
            topEnd = topRadius,
            bottomStart = bottomRadius,
            bottomEnd = bottomRadius,
        )
    return clip(clipShape)
}
