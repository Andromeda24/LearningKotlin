package org.ll.lab5_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import org.ll.lab5_2.ui.theme.Lab5_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContent {
            Lab5_2Theme {

           }
       // }
    }
}
