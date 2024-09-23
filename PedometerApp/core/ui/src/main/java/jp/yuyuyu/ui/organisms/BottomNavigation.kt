package jp.yuyuyu.ui.organisms

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import jp.yuyuyu.ui.util.PreviewDynamicTheme
import jp.yuyuyu.ui.util.TopLevelDestination

@Composable
fun BottomNavigation(
    topLevelDestinations: TopLevelDestination,
    onItemSelected: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (item in TopLevelDestination.entries) {
            NavigationBarItem(
                selected = topLevelDestinations == item,
                onClick = {
                    onItemSelected(item)
                },
                icon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = {
                    Text(text = stringResource(item.titleTextId))
                }
            )
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun BottomNavigation_Preview() {
    val selectedItem = remember { mutableStateOf(TopLevelDestination.HOME) }
    BottomNavigation(
        topLevelDestinations = selectedItem.value,
        onItemSelected = selectedItem::value::set
    )
}
