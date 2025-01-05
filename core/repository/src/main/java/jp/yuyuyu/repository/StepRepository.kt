package jp.yuyuyu.repository

import jp.yuyuyu.datasource.StepEntity

interface StepRepository {
    suspend fun getStepCount(date: String): StepEntity?

    suspend fun insertStepCount(stepCount: Int, date: String)

    suspend fun updateStepCount(stepCount: Int, date: String)
}
