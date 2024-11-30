// All you need to do is use the captureRoboImage function in the test!
/*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onParent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import jp.yuyuyu.pedometerapp.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode


// Tips: You can use Robolectric while using AndroidJUnit4
@RunWith(AndroidJUnit4::class)
// Enable Robolectric Native Graphics (RNG)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel5)
class ManualTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun captureRoboImageSample() {
        // Tips: You can use Robolectric with Espresso API
        // launch
        ActivityScenario.launch(MainActivity::class.java)

        // Capture screen
        onView(ViewMatchers.isRoot())
            // If you don't specify a screenshot file name, Roborazzi will automatically use the method name as the file name for you.
            // The format of the file name will be as follows:
            // build/outputs/roborazzi/com_..._ManualTest_captureRoboImageSample.png
            .captureRoboImage()

        // Capture Jetpack Compose Node
        composeTestRule.onNodeWithTag("AddBoxButton")
            .onParent()
            .captureRoboImage("build/compose.png")
    }
}
*/

