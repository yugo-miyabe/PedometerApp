package jp.yuyuyu.home


sealed class HomeSideEffect {
    data object RequestStepData : HomeSideEffect()
}
