package jp.yuyuyu.home.tutorial

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class TutorialViewModel @Inject constructor() : ContainerHost<TutorialState, TutorialSideEffect>,
    ViewModel() {
    override val container = container<TutorialState, TutorialSideEffect>(TutorialState())

}

data class TutorialState(
    val test: String = ""
)

sealed class TutorialSideEffect {
    data object RequestPermission : TutorialSideEffect()
}
