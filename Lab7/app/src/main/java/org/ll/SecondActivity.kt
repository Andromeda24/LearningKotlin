package org.ll

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.ll.ui.theme.Lab7Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activityContext: ComponentActivity? = context as? ComponentActivity // context as Activity
    val intent = activityContext?.intent // getIntent()
    val name = intent?.getStringExtra("name")
    val age = intent?.getIntExtra("age", 0)
    val isStudent = intent?.getBooleanExtra("isStudent", false)
    val hobbies = intent?.getStringArrayListExtra("hobbies")
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "Welcome $name of $age $isStudent $hobbies",
            modifier = modifier
        )
        for (hobby in hobbies!!) {
            Text(
                text = "let's learn $hobby together",
                modifier = modifier
            )
        }

        Button(
            onClick = {
        // if we call another activyty, it will be added to the stack. we need to go back instead
                val activity = context as? Activity // or ComponentActivity
                activity?.finish() // remove this activity from the stack
            }

        ) {
            Text(text = "Go Back")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Lab7Theme {
        Greeting2("Android")
    }
}