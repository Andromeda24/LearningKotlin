package org.ll.lab3_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter= painterResource(id=R.drawable.miu_logo),
                contentDescription = "image",

                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color=Color.Black,
                        shape = CircleShape

                    ) .clip(CircleShape)
                        .size(size=200.dp)

            )
            Text(
                text = "Hello",

            )
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