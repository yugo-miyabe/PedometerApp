package jp.yuyuyu.ui.template

import android.content.Intent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.common.R
import jp.yuyuyu.ui.molecules.ListItem
import jp.yuyuyu.ui.molecules.ListItemSwitch
import jp.yuyuyu.ui.theme.PedometerAppTheme

@Composable
fun SettingTemplate() {
    val health = "androidx.health.ACTION_HEALTH_CONNECT_SETTINGS"
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val insetsPadding =
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
            ).asPaddingValues()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            contentPadding = insetsPadding
        ) {
            item {
                ListItemSwitch(
                    text = stringResource(R.string.health_connect_settings),
                    isChecked = true,
                    isTop = true,
                    isBottom = false,
                    onClicked = { /* TODO */ },
                )
            }
            item {
                Spacer(modifier = Modifier.height(2.dp))
            }
            item {
                ListItem(
                    text = stringResource(R.string.access_permissions_manage),
                    isTop = false,
                    isBottom = true,
                    onClicked = {
                        val settingsIntent = Intent()
                        settingsIntent.action = health
                        context.startActivity(settingsIntent)
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ListItem(
                    text = stringResource(R.string.terms_of_service),
                    isTop = true,
                    isBottom = false,
                    onClicked = { /* TODO */ }
                )
            }
            item {
                Spacer(modifier = Modifier.height(2.dp))
            }
            item {
                ListItem(
                    text = stringResource(R.string.license),
                    isTop = false,
                    isBottom = true,
                    onClicked = { /* TODO */ }
                )
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun Setting_Preview() {
    PedometerAppTheme {
        Surface {
            SettingTemplate()
        }
    }
}
