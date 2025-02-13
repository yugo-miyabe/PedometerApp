package jp.yuyuyu.ui.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.common.R
import jp.yuyuyu.ui.atoms.Text
import jp.yuyuyu.ui.theme.PedometerAppTheme
import jp.yuyuyu.ui.theme.PedometerTypography

@Composable
fun BottomButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondaryContainer),
    ) {
        Column(
            modifier = Modifier.padding(contentPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = content
        )
    }
}

@PreviewLightDark
@Composable
private fun BottomButtonPreview() {
    PedometerAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomButton(
                    content = {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { /* preview */ },
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
            Spacer(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}
