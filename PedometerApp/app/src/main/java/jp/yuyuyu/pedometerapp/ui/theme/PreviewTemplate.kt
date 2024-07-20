package jp.yuyuyu.pedometerapp.ui.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers


@Preview(
    apiLevel = 33,
    name = "Red_Light",
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Blue_Light",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Green_Light",
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Yellow_Light",
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Red_Dark",
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Blue_Dark",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Green_Dark",
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Preview(
    apiLevel = 33,
    name = "Yellow_Dark",
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,

    )
annotation class PreviewDynamicTheme
