import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.RoborazziTaskType
import com.github.takahirom.roborazzi.captureRoboImage
import jp.yuyuyu.pedometerapp.getMetadata
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(ParameterizedRobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel5)
class PreviewTest(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    @OptIn(ExperimentalRoborazziApi::class)
    @Test
    fun previewScreenshot() {
        val roborazziOptions = RoborazziOptions(
            taskType = RoborazziTaskType.Record
        )
        val filePath =
            DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH + "/" + showkaseBrowserComponent.componentKey + ".png"
        captureRoboImage(
            filePath = filePath,
            roborazziOptions = roborazziOptions,
            content = {
                showkaseBrowserComponent.component()
            }
        )
    }

    companion object {
        @ParameterizedRobolectricTestRunner.Parameters
        @JvmStatic
        fun components(): Iterable<Array<Any?>> {
            return Showkase.getMetadata().componentList.map { showkaseBrowserComponent ->
                arrayOf(showkaseBrowserComponent)
            }
        }
    }
}
