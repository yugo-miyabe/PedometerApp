package jp.yuyuyu.home

import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.records.StepsRecord
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.yuyuyu.usecase.UpdateStepUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    updateStep: UpdateStepUseCase
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {
    override val container = container<HomeState, HomeSideEffect>(HomeState())

    init {
        updateStep
        intent {
            postSideEffect(HomeSideEffect.RequestStepData)
        }
    }

    fun requestRecode(healthConnectClient: HealthConnectClient) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val today = LocalDate.now(ZoneId.of(ZONE_ID))
                val startOfToday = today.atStartOfDay()
                val startTime: Instant = startOfToday.atZone(ZoneId.of(ZONE_ID)).toInstant()

                // 読み取りたい期間を指定
                val endTime = Instant.now()
                val timeRangeFilter = TimeRangeFilter.between(startTime, endTime)
                // 歩数データの読み取りリクエストを作成
                val request = ReadRecordsRequest(
                    recordType = StepsRecord::class,
                    timeRangeFilter = timeRangeFilter
                )
                val response = healthConnectClient.readRecords(request = request)
                // 歩数データの処理
                response.records.forEach { stepsRecord ->
                    // 歩数データを使って何か処理を行う
                    intent {
                        /*
                        reduce {
                            state.copy(
                                state.todayStep
                            )
                        }
                        */
                    }
                }
            } catch (e: Exception) {
                // エラーハンドリング
                Timber.d(e.message)
            }
        }
    }

    companion object {
        const val ZONE_ID = "Asia/Tokyo"
    }

    fun updateStepCount(stepCount: Int) = intent {
        reduce {
            state.copy(stepCount = stepCount)
        }
    }
}
