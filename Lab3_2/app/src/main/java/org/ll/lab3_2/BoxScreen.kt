package org.ll.lab3_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BoxScreen (modifier: Modifier = Modifier) {

   // create 3 images. 1 and 3 fixed in the cornersand iage 2 is bigger and change while clicking he other two
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            // var myImage = Icons.Default.Person
            // myImage is a local variable tah is reser whenever the screen is recomposed
            //to store the last value use remember function
            //
            var myImage by remember { mutableStateOf( Icons.Default.Person) }
            Image (imageVector = Icons.Default.Lock,
                contentDescription = "lock icon",
               modifier = Modifier.size(50.dp)
                   .align(Alignment.TopStart)
                   .clickable (
                       onClick = {
                           //  action

                           if (myImage == Icons.Default.Person) {
                               myImage = Icons.Default.Lock
                           } else {
                               myImage = Icons.Default.Person
                           }
                       }

                   )
                )

            Image (imageVector = myImage,
                contentDescription = "main icon",
                modifier = Modifier.size(200.dp))

            Image (imageVector = Icons.Default.Favorite,
                contentDescription = "lock icon",
                modifier = Modifier.size(50.dp)
                    .align(Alignment.TopEnd)
                    .clickable (
                        onClick = {

                            if (myImage == Icons.Default.Person) {
                                myImage = Icons.Default.Favorite
                            } else {
                                myImage = Icons.Default.Person
                            }
                        }

                    )
            )

        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun BoxScreenPreview (modifier: Modifier = Modifier) {
    BoxScreen()
    
}