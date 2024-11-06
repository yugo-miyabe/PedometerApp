package jp.yuyuyu.timeline

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TimeLineViewModel @Inject constructor() : ViewModel() {
    init {
        Timber.d("miyabe")
    }
}
