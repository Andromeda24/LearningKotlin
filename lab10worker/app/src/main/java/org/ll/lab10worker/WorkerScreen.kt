package org.ll.lab10worker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.WorkManager

@Composable
fun WorkerScreen(modifier: Modifier = Modifier) {

   val context = LocalContext.current
    val workManager = WorkManager.getInstance(context)
    val workerViewModel: WorkerViewModel = viewModel() {
        WorkerViewModel(workManager)
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    workerViewModel.startWork()
                }
            ) {
                Text("Start")
            }

            Button(
                onClick = {
                    workerViewModel.cancelWork()
                }
            ) {
                Text("Cancel")
            }

            Button(
                onClick = {
                    workerViewModel.startAsyncWork()
                }
            ) {
                Text("Start Async")
            }
            /*
            val state = workerViewModel.workUiState.
            //when (state){

            //}
            Text ("$state")
        } */

        }
    }
}