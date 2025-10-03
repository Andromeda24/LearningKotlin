package org.ll.lab3_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextStyleScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column (
            modifier = modifier
                .padding (paddingValues = innerPadding)
                .fillMaxSize()
        ) {
             // Text 1: change many properties
            Text( //look for API Documentation for parameters and values
                //https://developer.android.com/reference/kotlin/androidx/compose/ui/text/package-summary.html
                text = "Welcome!",
                color = Color.Red,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            ) 
            //    Text2 change FontFamily a

            Text( //look for API Documentation for parameters and values
              // ctr+Q
                text = "Hello compose",
                color = Color.Magenta,
                fontSize = 15.sp,
                fontFamily = FontFamily.Cursive,

            )
            // Text3 Use TextStyle to do a shadow
            Text(
                text = "Android Jetpack Compose",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(0xFF1C862A),
                        // blurRadius = 30f,
                        offset = Offset(
                            x = 5f,
                            y = 5f
                        )
                    )
                )
            )


// Text 4 use textsyte to brush to fill it with a degrade of colors
            Text(
                text = "Compose is fun with a rainbow brush",
                modifier = Modifier.background(color = Color.Gray),
               style = TextStyle(
                   brush = Brush.linearGradient(
                        colors = listOf( Color(148,0,211,255), // Violet
                            Color(75,0,130,255), // dark blue
                            Color.Blue,
                            Color.Green,
                            Color.Yellow,
                            Color(255, 127, 0,255), //Orange
                            Color.Red )
                   )
               )
            )
        }
        }
}

@Preview (
    showSystemUi = true
)

@Composable
fun showText(modifier: Modifier = Modifier) {
    TextStyleScreen(modifier)
}

