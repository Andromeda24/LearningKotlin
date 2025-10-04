package org.ll.lab4



import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ll.lab4.data.DataSource

// type comp for make it filling the @composable staff
@Composable
fun ColScreen (modifier: Modifier = Modifier) {

    // Using col layuot


    //How to load an image?

    // jpg and other (non-java,non-kotlin resource)
    // copy it in the folder drawable
    // reference it as is unique id = R.drawable.name

    // svg - impor it in the IDE use as image vector
    Scaffold { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            // version 1 load text items

            //1. Item from fixed Text
            item {
                Text( text = "MIU")
            }


           // 2. Add 10 items
             items(10) {
                 Text(text = "Index: $it")
             }
            // 3. add alist of Items
             //   items(10){}
              //  listOf("Android", "iOS", "Web", "Desktop")
              //  ) {Text(text = "Item: $it")}

            // Add another single item
                item {Text(text = "End")}

            // version2 load images with text
/*
            items (DataSource.loadData())
            Column {

                Image(
                    painter = painterResource((item.tile))
                    contentDescription = stringResource(item.title)
                    modifier = Modifier
                )
            }
                         */


            }

            }


}

@Preview(
    showSystemUi = true
)
@Composable
fun ColScreenPreview (modifier: Modifier = Modifier) {
    ColScreen()

}