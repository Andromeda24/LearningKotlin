package org.ll.lab5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

            val counterViewModel: CounterViewModel = viewModel{
                CounterViewModel()
            }
            val counterUIState: CounterUIState by counterViewModel.counterUiState
            Text(text = "${counterUIState.count}")
            Spacer(modifier=Modifier.padding(20.dp))
            Row (

            ){
                Button(
                    onClick= { counterViewModel.increment()}
                ){
                    Text("Increment")
                }
                Button(
                    onClick= { counterViewModel.decrement()}
                ){
                    Text("Decrement")
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