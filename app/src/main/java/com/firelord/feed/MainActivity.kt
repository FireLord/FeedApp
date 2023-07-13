package com.firelord.feed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.firelord.feed.compose.TvShowListItem
import com.firelord.feed.data.TvShowList
import com.firelord.feed.model.TvShow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //LazyColumnDemo2{ Toast.makeText(this,it,Toast.LENGTH_SHORT).show() }
            DisplayTvShows{
                Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ScrollableColumnDemo(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
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

@Composable
fun LazyColumnDemo(){
    LazyColumn{
        items(100){
            Text(
                "User Name $it",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem: (String)->(Unit)){
    LazyColumn{
        items(100){
            Text(
                "User Name $it",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") }
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

// Display tvShow list
@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit){
    val tvShows = remember { TvShowList.tvShows }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem = selectedItem)
            }
        )
    }
}