package org.ll.lab4



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ll.lab4.data.DataSource

@Composable
fun LazyVerticalGridScreen (modifier: Modifier = Modifier) {

   
    Scaffold { innerPadding ->
        LazyVerticalGrid (
            columns = GridCells.Adaptive(200.dp),
            modifier = Modifier
                .padding(innerPadding)
         //       .fillMaxSize()
         //       .fillMaxHeight()
        ) {
            items(DataSource.loadData()) { item ->
                Image(
                    painter = painterResource(item.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}

@Preview(
    showSystemUi = true
)
@Composable
fun LazyVerticalGridPreview()  {
    LazyVerticalGridScreen()

}