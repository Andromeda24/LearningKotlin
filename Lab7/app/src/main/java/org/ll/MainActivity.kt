package org.ll

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ll.ui.theme.Lab7Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        val context = LocalContext.current // this screeens context
        Button(
            onClick = {
                println("Button Clicked")
                //1. create the intent
                var intent = Intent(context, SecondActivity::class.java)
                // 2. pass data to the intent
                /* version 1
                intent.putExtra("name","John")
                intent.putExtra("age", 20)
                intent.putExtra("isStudent", true)
                */
                // version 2
                // put Extra can be used as many lines after creation o as a {} parameter of the function apply
                 .apply {
                    putExtra("name","John")
                    putExtra("age", 20)
                    putExtra("isStudent", true)
                     putStringArrayListExtra(
                         "hobbies",
                         arrayListOf("reading", "cooking")
                     )
            }


                // 3. start the activity
                context.startActivity(intent)

            },
            modifier = Modifier.padding(24.dp)
        ) {
            Text(text ="Go to the Next Screen")
        }

        Button(
            onClick = {
                val intent = Intent (Intent.ACTION_SEND).apply {
                    // version 1 text
                    //type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Hello from my app")
                    // in the real phone, it shows all the apps that can handle a text message
                }
                /*
                val intent2 = Intent (Intent.ACTION_SEND).apply {

                //Version 2 email
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_TEXT, "Hello from my app")
                    putExtra(Intent.EXTRA_EMAIL,arrayOf("llamprea@hotmail.com",
                        "lindajessicar@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "A message from my app")
                }
*/

                    //Version make a call.
                    makeCall(context, "1234567890")

            }
        )  {
                Text(text ="Share some data")
            }


            }
}

// requires permissions in the manifest

/*
<uses-feature
android:name="android.hardware.telephony"
android:required="false" /> false means that without the permission the app will not run
true that means that the app will run without the permission but the user will not be able to make calls
<uses-permission android:name="android.permission.CALL_PHONE" />
 */
fun makeCall(context: Context, phoneNumber: String) {
    context as Activity

    // todo complete and test this function
    if (context.checkSelfPermission(android.Manifest.permission.CALL_PHONE) !=
        PackageManager.PERMISSION_GRANTED){
      return
    }
    val intent = Intent(Intent.ACTION_CALL).apply {
        data = Uri.parse("tel:$phoneNumber")

    }
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7Theme {
        Greeting("Android")
    }
}