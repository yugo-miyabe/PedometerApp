package jp.yuyuyu.tutorial

sealed class TutorialSideEffect {
    data object RequestPermission : TutorialSideEffect()
}
