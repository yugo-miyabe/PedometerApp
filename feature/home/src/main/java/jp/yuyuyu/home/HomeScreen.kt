package jp.yuyuyu.home

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import jp.yuyuyu.ui.template.HomeTemplate
import org.orbitmvi.orbit.compose.collectSideEffect
import kotlin.math.max

@Composable
fun HomeScreen(
    onSettingClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    viewModel.collectSideEffect {
        when (it) {
            HomeSideEffect.RequestStepData -> {
                // センサー管理の設定
                val sensorManager: SensorManager =
                    context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
                var previousTotalSteps = 0f

                val listener = object : SensorEventListener {
                    // センサー値が変更されたとき
                    override fun onSensorChanged(event: SensorEvent?) {
                        if (event == null) return
                        val currentSteps = event.values[0]
                        if (previousTotalSteps == 0f) {
                            previousTotalSteps = currentSteps
                        }
                        // 今日の歩数を計算して更新
                        viewModel.updateStepCount(
                            max(currentSteps - previousTotalSteps, 0f).toInt()
                        )
                    }

                    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                        // 何もしない
                    }
                }

                val stepSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
                sensorManager.registerListener(listener, stepSensor, SensorManager.SENSOR_DELAY_UI)
            }
        }
    }

    HomeTemplate(
        todayStep = state.stepCount,
        onClick = onSettingClick
    )
}
