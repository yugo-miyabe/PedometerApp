package jp.yuyuyu.repository

interface StepRepository {
    suspend fun updateStepCount(stepCount: Int, date: String)
}
