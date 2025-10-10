package org.ll.lab5_2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab5_2.model.ABRepositoryImpl
import org.ll.lab5_2.ui.theme.Lab5_2Theme

@Composable
fun ABEScreen (modifier: Modifier = Modifier) {
    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // get ViewModel Instance
            val myViewModel: ABEViewModel = viewModel {
                ABEViewModel(ABRepositoryImpl())
            }

            val myState: State<ABEUIState> = myViewModel.currentState.collectAsState()
            Text(text = "${myState.value.alphabet}")
            Spacer(modifier=Modifier.padding(20.dp))
            Text(text = myState.value.word)
            Row (

            ){
                Button(
                    onClick= { myViewModel.nextAlphabet()}
                ){
                    Text("Explore")
                }

            }

        }

    }

}

@Preview(
    showSystemUi = true
)

@Composable
fun ABEScreenPreview(modifier: Modifier = Modifier) {
    Lab5_2Theme {

    }
}