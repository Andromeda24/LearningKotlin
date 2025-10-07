package org.ll.lab5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab5.MainScreen
import org.ll.lab5.ui.theme.Lab5Theme

@Composable
fun CounterScreen(modifier: Modifier = Modifier) {

    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // if we write val counterViewModel: CounterViewModel = CounterViewModel()  the recomposition
            // will create a new object every time
            // to use viewmodel is necesary to add the dependeence in build.gradle.kts file
            //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")
            val counterViewModel: CounterViewModel = viewModel{
                CounterViewModel() //initializes the viewmodel
            }
            val counterUIState: CounterUIState by counterViewModel.counterUiState.collectAsState()
            // init the observer to the state in the viewModel
            Text(text = "${counterUIState.count}")
            //Text(text = "")
            Spacer(modifier=Modifier.padding(20.dp))
            Row (

            ){
                Button(
                    onClick= { counterViewModel.increment() } // all the actions are sent to the viewmodel
                ){
                    Text("Increment")
                }
                Button(
                    onClick= { counterViewModel.decrement()}
                ){
                    Text("Decrement")
                }
            }
            when {
                counterUIState.isLoading -> {
                    Text("Loading")
                    CircularProgressIndicator() // do not have effect in this project

                }
                counterUIState.errorMessage != null -> {
                    Text("${counterUIState.errorMessage}")
                }
                else -> {
                    Text("Load complete")
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    Lab5Theme {
        CounterScreen()
    }
}