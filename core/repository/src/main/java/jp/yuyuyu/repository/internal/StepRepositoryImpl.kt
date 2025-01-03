package jp.yuyuyu.repository.internal

import jp.yuyuyu.datasource.StepDao
import jp.yuyuyu.datasource.StepEntity
import jp.yuyuyu.repository.StepRepository
import java.util.Date

internal class StepRepositoryImpl(
    private val stepDao: StepDao
) : StepRepository {

    override suspend fun updateStepCount(stepCount: Int, date: String) {
        stepDao.insert(StepEntity(step = stepCount, date = date))
    }
}
