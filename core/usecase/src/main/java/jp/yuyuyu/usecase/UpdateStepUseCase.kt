package jp.yuyuyu.usecase

import jp.yuyuyu.repository.StepRepository
import javax.inject.Inject

class UpdateStepUseCase @Inject constructor(
    private val stepRepository: StepRepository,
) {
    suspend operator fun invoke(stepCount: Int, date: String) {
        stepRepository.updateStepCount(stepCount = stepCount, date = date)
    }
}
