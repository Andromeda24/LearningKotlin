package org.ll.lab4



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ll.lab4.data.DataSource

// type comp for make it filling the @composable staff
@Composable
fun LazyRowScreen (modifier: Modifier = Modifier) {

    // Using col layuot


    //How to load an image?

    // jpg and other (non-java,non-kotlin resource)
    // copy it in the folder drawable
    // reference it as is unique id = R.drawable.name

    // svg - import it in the IDE use as image vector
    Scaffold { innerPadding ->
        LazyRow(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            // version 1 load text items
            /*
            //1. Item from fixed Text
            item {
                Text( text = "MIU")
            }


           // 2. Add 10 items
             items(10) {
                 Text(text = "Index: $it")
             }
            // 3. add a list of Items


            items(listOf("A","B","C","D","E") )
            {Text(text = "Item: $it")}

            // Add another single item
                item {Text(text = "End")}
*/
            // version2 load images with text

            items(DataSource.loadData()) { item ->
                // Column () version 1. easy but not good with different image sizes
                // Card () version 2
                Card() // allows it to look pretty handling image/text as an unit with borders and so on

                {
                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier.height(200.dp),

                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = stringResource(item.title)
                    )

                }
            }
        }
    }

}

@Preview(
    showSystemUi = true
)
@Composable
fun RowScreenPreview (modifier: Modifier = Modifier) {
    LazyRowScreen()

}