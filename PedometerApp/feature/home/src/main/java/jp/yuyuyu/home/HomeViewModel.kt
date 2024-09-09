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
import timber.log.Timber
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    fun requestRecode(healthConnectClient: HealthConnectClient) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // 読み取りたい期間を指定
                val startTime = Instant.now().minusSeconds(60 * 60 * 24) // 24時間前
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
                    val steps = stepsRecord.count
                    val startTime = stepsRecord.startTime
                    val endTime = stepsRecord.endTime
                    // 歩数データを使って何か処理を行う
                }
            } catch (e: Exception) {
                // エラーハンドリング
                Timber.d(e.message)
            }
        }
    }
}
