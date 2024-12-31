package jp.yuyuyu.ui.organisms

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp

// TODO 修正する
@Composable
@Suppress("MagicNumber")
fun AnimatedCircle(
    proportions: List<Float>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    // アニメーションの状態を定義、STARTからENDへと変化する
    val currentState: MutableTransitionState<AnimatedCircleProgress> = remember {
        MutableTransitionState(AnimatedCircleProgress.START)
            .apply { targetState = AnimatedCircleProgress.END }
    }
    //　プログレスバーの太さを調整
    val stroke: Stroke = with(LocalDensity.current) { Stroke(5.dp.toPx()) }
    // currentStateの変化に応じて、アニメーションのトランジションを管理
    val transition = rememberTransition(currentState)
    // tween: アニメーションの開始値、終了値、時間、イージングなどを指定するための関数
    // animateFloat: アニメーションの開始値、終了値を指定するための関数
    val angleOffset by transition.animateFloat(
        transitionSpec = {
            tween(
                delayMillis = 500,
                durationMillis = 900,
                easing = LinearOutSlowInEasing
            )
        }, label = ""
    ) { progress ->
        // 0fから360fへとアニメーションする値を計算しています。この値は、円弧の描画範囲を決定
        if (progress == AnimatedCircleProgress.START) {
            0f
        } else {
            360f
        }
    }
    // shift: transition.animateFloatを用いて、currentStateが変化する際に、0fから30fへとアニメーションする値を計算しています。
    // この値は、円弧の開始角度をずらすことで、より複雑なアニメーションを実現しています。
    val shift by transition.animateFloat(
        transitionSpec = {
            tween(
                delayMillis = 500,
                durationMillis = 900,
                easing = CubicBezierEasing(0f, 0.75f, 0.35f, 0.85f)
            )
        }, label = ""
    ) { progress ->
        if (progress == AnimatedCircleProgress.START) {
            0f
        } else {
            30f
        }
    }

    Canvas(modifier) {
        val innerRadius = (size.minDimension - stroke.width) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - innerRadius,
            halfSize.height - innerRadius
        )
        val size = Size(innerRadius * 2, innerRadius * 2)
        // 円の開始角度
        var startAngle = shift - 90f
        proportions.forEachIndexed { index, proportion ->
            val sweep = proportion * angleOffset
            drawArc(
                color = colors[index],
                startAngle = startAngle + 1.8f / 2,
                sweepAngle = sweep - 1.8f,
                topLeft = topLeft,
                size = size,
                useCenter = false,
                style = stroke
            )
            startAngle += sweep
        }
    }
}

private enum class AnimatedCircleProgress { START, END }

@Composable
@PreviewLightDark
@Suppress("MagicNumber")
private fun AnimatedCirclePreview() {
    AnimatedCircle(
        proportions = listOf(
            0.025059527f,
            0.66295046f,
            0.04824622f,
            0.042760305f,
        ),
        colors = listOf(
            Color(0xFF004940),
            Color(0xFF005D57),
            Color(0xFF04B97F),
            Color(0xFF37EFBA)
        ),
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    )
}
