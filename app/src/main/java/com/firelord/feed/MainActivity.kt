package com.firelord.feed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firelord.feed.ui.theme.FeedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumnDemo()
        }
    }
}

@Composable
fun ScrollableColumnDemo(){
    Column {
        for (i in 1..100){
            Text(
                "User Name $i",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }

    }
}