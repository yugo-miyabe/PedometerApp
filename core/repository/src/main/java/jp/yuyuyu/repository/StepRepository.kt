package jp.yuyuyu.repository

import jp.yuyuyu.model.StepModel

interface StepRepository {
    suspend fun getStepCount(date: String): StepModel

    suspend fun insertStepCount(stepCount: Int, date: String)

    suspend fun updateStepCount(stepCount: Int, date: String)
}
