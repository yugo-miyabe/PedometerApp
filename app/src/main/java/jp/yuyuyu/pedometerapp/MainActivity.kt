package jp.yuyuyu.pedometerapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import jp.yuyuyu.pedometerapp.navigation.PedometerNavHost
import jp.yuyuyu.ui.theme.PedometerAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PedometerAppTheme {
                CompositionLocalProvider {
                    PedometerNavHost()
                }
            }
        }
    }
}
