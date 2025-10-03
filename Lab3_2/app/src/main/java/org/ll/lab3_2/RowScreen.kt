package org.ll.lab3_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// type comp for make it filling the @composable staff
@Composable
fun RowScreen (modifier: Modifier = Modifier) {

    // Version 1. display two texts with no layout => texts overlap one to each other
    /*Scaffold { innerPadding ->
        Text (
            text = "MIU",
            modifier = Modifier.padding(innerPadding)
        )
        Text (
            text = "Fairfield",
            modifier = Modifier.padding(innerPadding)
        )
    }*/
    // Version 2. Using row layout
    Scaffold { innerPadding ->
        Row (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "MIU",
                color = Color.White,
                modifier = Modifier
                        .background(Color.Green)
                        .weight(weight = 1f) //each component uses 50% of the width

            )
            Text(
                text = "Fairfield",
                modifier = Modifier
                .weight(weight = 1f) //each component uses 50% of the width

            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun RowScreenPreview (modifier: Modifier = Modifier) {
    RowScreen()
    
}