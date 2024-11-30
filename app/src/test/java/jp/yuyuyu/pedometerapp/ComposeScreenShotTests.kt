package jp.yuyuyu.pedometerapp

import androidx.activity.ComponentActivity
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import jp.yuyuyu.designsystem.theme.PedometerAppTheme
import jp.yuyuyu.ui.template.HomeTemplate
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel7Pro)
class ComposeScreenShotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val roborazziOptions = RoborazziOptions(
        compareOptions = RoborazziOptions.CompareOptions(changeThreshold = 0F),
    )

    @Test
    fun checkSettingsScreen() {
        checkComposeScreen(
            screenName = "HomeScreen",
            content = {
                HomeTemplate(
                    todayStep = 10,
                    onClick = {/* preview */ }
                )
            }
        )
    }


    private fun checkComposeScreen(
        screenName: String,
        content: @Composable () -> Unit
    ) {
        composeTestRule.setContent {
            PedometerAppTheme {
                Surface {
                    content()
                }
            }
        }

        composeTestRule.onRoot().captureRoboImage(
            filePath = "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/$screenName.png",
            roborazziOptions = roborazziOptions
        )
    }
}