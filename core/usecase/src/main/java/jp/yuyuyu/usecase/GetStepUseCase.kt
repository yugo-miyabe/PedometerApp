package jp.yuyuyu.usecase

import jp.yuyuyu.repository.StepRepository
import javax.inject.Inject

class GetStepUseCase @Inject constructor(
    private val stepRepository: StepRepository,
) {
    suspend operator fun invoke(date: String) = stepRepository.getStepCount(date = date)
}
