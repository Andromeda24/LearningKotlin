package org.ll.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ll.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Version 1
                    // The problem with this solution in that mixes data and UI in the same file
                    //
                    /* MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    // Version2
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var counter by remember{
        mutableIntStateOf(0)
        //the name of the function changes according to the type of the variable
        //use mutableStateOf for String, and Long, Double, ann Float for other numbers
    }
    var increment = {counter++}
    var decrement = {counter--}

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text("$counter")
        Spacer(modifier=Modifier.padding(20.dp))
        Row (

        ){
            Button(
                onClick= { counter= increment()}
            ){
                Text("Increment")
            }
            Button(
                onClick= { counter =  decrement()}
            ){
                Text("Decrement")
            }
        }

  }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    Lab5Theme {
        MainScreen()
    }
}