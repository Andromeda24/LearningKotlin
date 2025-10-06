package org.ll.lab3_2

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen (modifier: Modifier = Modifier) {

    // Display a form to capture the input data
// create a textField to hold the input observable value
    Scaffold { innerPadding ->
        Column (
            modifier = modifier
                .padding(paddingValues = innerPadding)
                .fillMaxSize()
                .fillMaxWidth()

        ){
            val context = LocalContext.current
            var username by remember { mutableStateOf (value = "") }
            var usernameError by remember { mutableStateOf (value = false)}
            // the by keywords delegates getters and setters to MutableState
            // by default, the text is stored nowhere, so you need to handle manually the event of typying each letter and store it in a variable

            if (username.isNotEmpty()) {
                Text(
                    text = "Hello, $username!",
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = MaterialTheme.typography.bodyLarge,

                )
            }

            TextField(
                value=username,
                onValueChange = {
                    data -> username = data
                },
                label = { Text(text="username")},
                keyboardOptions = KeyboardOptions (keyboardType =KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp) , // shaping the keyboard into the screen
                isError = usernameError,
                supportingText = {
                    if (usernameError) {
                        Text(text = "Username is required")
                    }
                }
            )

            var password by remember { mutableStateOf (value = "") }

            OutlinedTextField(
                value=password,
                onValueChange = {
                        //data -> password = data
                        password = it // other way to write the function
                },
                label = { Text(text="Password")},
                keyboardOptions = KeyboardOptions (keyboardType = KeyboardType.NumberPassword),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)  // shaping the keyboard into the screen
            )

            var phoneNumber by remember { mutableStateOf (value = "") }
            
            OutlinedTextField(
                value=phoneNumber,
                onValueChange = {
                    phoneNumber = it // other way to write the function
                },
                label = { Text(text="PhoneNumber")},
                keyboardOptions = KeyboardOptions (keyboardType =KeyboardType.Number),
                placeholder = { Text("Phone number")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)  // shaping the keyboard into the screen
            )
            
             // RadioButton to select Gender

            val genders = listOf ("Male","Female")
            var selectedGender by remember { mutableStateOf (value = genders[0]) }

            Row (

            ) {
                genders.forEach { gender ->
                    RadioButton(
                        selected = selectedGender == gender,
                        onClick = {
                            selectedGender = gender

                        }
                    )
                    Text(text = gender)
                    // @todo include radio button and text in a row layout to look preety
                }
            }
            // Include submit and clear buttons
            // Create a row that includes two buttons

            Row (

            ){

                // future research : with custom views, you can customize the button
                Button(
                    onClick = {
                        username = ""
                        password = ""
                        phoneNumber = ""
                        selectedGender = genders[0]
                        usernameError = false
                  },

                ) {
                    Text ( text = "Clear")
                }

                Button(
                    onClick = {

                        // 1. Validate the input and show the supportedText in red and a trailerIcon
                        if (username.isEmpty()){
                            usernameError = true
                        } else {
                            usernameError = false
                            // 2. create a toast
                            val toast = Toast.makeText(
                                context,
                                "Registration successful for $username ",
                                Toast.LENGTH_SHORT
                            )
                            toast.show()
                        }
                    },

                    ) {
                    Text ( text = "Submit")
                }
            }
        }
    }

}
@Preview(
    showSystemUi = true
)
@Composable
fun RegistrationScreenPreview(modifier: Modifier = Modifier) {
    RegistrationScreen()
}