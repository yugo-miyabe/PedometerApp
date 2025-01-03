package jp.yuyuyu.usecase

import jp.yuyuyu.repository.StepRepository

sealed class UpdateStepUseCase(
    private val stepRepository: StepRepository
) {
    suspend operator fun invoke(stepCount: Int, date: String) {
        stepRepository.updateStepCount(stepCount = stepCount, date = date)
    }
}
