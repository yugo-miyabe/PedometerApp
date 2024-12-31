package jp.yuyuyu.ui.organisms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import jp.yuyuyu.common.R
import jp.yuyuyu.ui.atoms.Text
import jp.yuyuyu.ui.theme.PedometerAppTheme
import jp.yuyuyu.ui.theme.PedometerTypography

@Composable
fun StepCount(stepCount: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(R.string.today),
            style = PedometerTypography.titleSmall
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            text = stepCount,
            textAlign = TextAlign.End,
            style = PedometerTypography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@PreviewLightDark
@Composable
private fun StepCount_Preview() {
    PedometerAppTheme {
        StepCount(stepCount = "100")
    }
}
