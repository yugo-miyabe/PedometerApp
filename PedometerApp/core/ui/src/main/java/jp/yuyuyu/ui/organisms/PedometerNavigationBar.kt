package jp.yuyuyu.ui.organisms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jp.yuyuyu.ui.util.PreviewDynamicTheme
import jp.yuyuyu.ui.util.TopLevelDestination

@Composable
fun PedometerNavigationBar(
    selectedItem: TopLevelDestination,
    onItemSelected: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 0.dp,
    ) {
        for (item in TopLevelDestination.entries) {
            val selected = item == selectedItem
            NavigationBarItem(
                selected = selected,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.titleTextId),
                    )
                },
                alwaysShowLabel = true,
            )
        }
    }
}

@PreviewDynamicTheme
@Composable
private fun KabuPassNavigationBar_Preview() {
    val selectedItem = remember { mutableStateOf(TopLevelDestination.HOME) }
    PedometerNavigationBar(
        selectedItem = selectedItem.value,
        onItemSelected = selectedItem::value::set,
    )
}
