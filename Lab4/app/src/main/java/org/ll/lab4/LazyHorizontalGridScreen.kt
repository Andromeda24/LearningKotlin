package org.ll.lab4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun LazyHorizontalGridScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        LazyVerticalGrid(columns= GridCells.Fixed(2),
            modifier = Modifier.padding(innerPadding)
        ) {
            //
            /* items(
                DataSource.loadData(),
                itemContent = TODO()
            )
                      Image (
                painter = painterResource(id = it.image)
            )

             */
             // temporary texts
            val myItems = listOf ("yo","tu","el")

        }
// todo show the images in vertical and horizontal grids with adaptative column number
    }
}
