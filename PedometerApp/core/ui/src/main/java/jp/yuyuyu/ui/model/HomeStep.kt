package jp.yuyuyu.ui.model

import java.time.Instant

data class HomeStep(
    val steps: Long,
    val startTime: Instant,
    val endTime: Instant
)