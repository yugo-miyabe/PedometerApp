package jp.yuyuyu.ui.organisms

/*
@Composable
fun PedometerNavigationBar(
    selectedItem: TopLevelDestination,
    onItemSelected: (jp.yuyuyu.pedometerapp.TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 0.dp,
    ) {
        for (item in jp.yuyuyu.pedometerapp.TopLevelDestination.entries) {
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
    val selectedItem = remember { mutableStateOf(jp.yuyuyu.pedometerapp.TopLevelDestination.HOME) }
    PedometerNavigationBar(
        selectedItem = selectedItem.value,
        onItemSelected = selectedItem::value::set,
    )
}
*/
