package jp.yuyuyu.repository.internal

import jp.yuyuyu.datasource.StepDao
import jp.yuyuyu.datasource.StepEntity
import jp.yuyuyu.model.StepModel
import jp.yuyuyu.repository.StepRepository

internal class StepRepositoryImpl(
    private val stepDao: StepDao
) : StepRepository {
    override suspend fun getStepCount(date: String): StepModel {
        return stepDao.getStepToday(date = date)?.toModel()
            ?: StepModel(
                date = date,
                todayStepCount = 0
            )
    }

    override suspend fun insertStepCount(stepCount: Int, date: String) {
        stepDao.insert(StepEntity(step = stepCount, date = date))
    }

    override suspend fun updateStepCount(stepCount: Int, date: String) {
        val stepEntity = stepDao.getStepToday(date = date)
        if (stepEntity == null) {
            insertStepCount(stepCount = stepCount, date = date)
        } else {
            stepDao.update(StepEntity(step = stepCount, date = date))
        }
    }

    private fun StepEntity.toModel() = StepModel(
        date = date,
        todayStepCount = step,
    )
}
