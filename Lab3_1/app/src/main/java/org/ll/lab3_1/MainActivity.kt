package org.ll.lab3_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ll.lab3_1.ui.theme.Lab3_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             Lab3_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
// only one composable function can call another composable function
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // version 1 simple text
/*
    Text(
        text = "Hello $name!",
        modifier = modifier
    ) */
    //version 2 formated text
    Text(
        text = "Hello $name!",
        modifier = modifier.background (
              color = Color.LightGray
            ).fillMaxSize(),
        //modifier,
        color = Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview( showSystemUi = true,
    showBackground = true)
@Composable
fun GreetingPreview() {
    Lab3_1Theme {
         //  Version 1  app overlaps the system headers
/*
             Greeting("Android",
             modifier = Modifier)
*/
        //  Version 2 manualy handling the overlapping
/*
                    Greeting("Android",
                    modifier = Modifier.padding(top=100.dp, start = 100.dp))
*/
        // Version 3 That's the one!

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            // provides the default distribution
            Greeting(
                name = "Luisa",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}