package jp.yuyuyu.usecase

import jp.yuyuyu.repository.StepRepository
import javax.inject.Inject
import jp.yuyuyu.model.StepModel

class GetStepUseCase @Inject constructor(
    private val stepRepository: StepRepository,
) {
    suspend operator fun invoke(date: String): StepModel = stepRepository.getStepCount(date = date)
}
