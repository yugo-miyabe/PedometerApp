package jp.yuyuyu.home

import jp.yuyuyu.ui.model.HomeStep

data class HomeState(
    val list: List<HomeStep> = emptyList()
)
