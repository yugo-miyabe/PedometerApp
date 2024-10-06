package jp.yuyuyu.home.tutorial

sealed class TutorialSideEffect {
    data object RequestPermission : TutorialSideEffect()
}
