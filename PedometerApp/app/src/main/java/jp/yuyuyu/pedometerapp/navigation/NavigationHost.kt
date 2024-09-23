package jp.yuyuyu.pedometerapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PedometerApp(modifier: Modifier = Modifier) {
    // TODO
}

@Composable
fun RootPage(modifier: Modifier) {
    Scaffold(
        bottomBar = {
            // TODO BottomBar
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = innerPadding
            ) {
                item {
                    Text(text = "Setting_1")
                }
                item {
                    Text(text = "Setting_2")
                }
                item {
                    Text(text = "Setting_3")
                }
                item {
                    Text(text = "Setting_4")
                }
                item {
                    Text(text = "Setting_5")
                }
            }
        },
    )
}
