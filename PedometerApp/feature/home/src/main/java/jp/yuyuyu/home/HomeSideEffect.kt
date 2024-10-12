package jp.yuyuyu.home


sealed class HomeSideEffect {
    data object RequestPermission : HomeSideEffect()
}
