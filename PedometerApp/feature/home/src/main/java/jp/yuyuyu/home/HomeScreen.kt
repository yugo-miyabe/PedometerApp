package jp.yuyuyu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column() {
            Text(text = "Home")
            Text(text = "Home")
            Text(text = "Home")
            Text(text = "Home")
            Text(text = "Home")
            Text(text = "Home")
        }
    }
}

@Composable
private fun Home_Preview() {

}



