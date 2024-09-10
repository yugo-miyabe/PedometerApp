package jp.yuyuyu.home

import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.records.StepsRecord
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {
    override val container = container<HomeState, HomeSideEffect>(HomeState())

    fun requestRecode(healthConnectClient: HealthConnectClient) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // 読み取りたい期間を指定
                val todayStart: LocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN)
                val endTime: LocalDateTime = LocalDateTime.now()
                val timeRangeFilter = TimeRangeFilter.between(todayStart, endTime)
                // 歩数データの読み取りリクエストを作成
                val request = ReadRecordsRequest(
                    recordType = StepsRecord::class,
                    timeRangeFilter = timeRangeFilter
                )
                val response = healthConnectClient.readRecords(request = request)
                // 歩数データの処理
                response.records.forEach { stepsRecord ->
                    val steps = stepsRecord.count
                    val startTime = stepsRecord.startTime
                    val endTime = stepsRecord.endTime
                    // 歩数データを使って何か処理を行う
                    intent {
                        reduce {
                            state.copy(
                                list = state.list + ("steps: $steps  startTime: $startTime  endTime: $endTime")
                            )
                        }
                    }
                }

            } catch (e: Exception) {
                // エラーハンドリング
                Timber.d(e.message)
            }
        }
    }

}

data class HomeState(
    val list: List<String> = emptyList()
)

sealed class HomeSideEffect {
    data object HideRefreshIndicator : HomeSideEffect()
}
