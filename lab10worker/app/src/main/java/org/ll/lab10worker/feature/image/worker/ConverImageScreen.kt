package org.ll.lab10worker.feature.image.worker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.WorkManager
import org.ll.lab10worker.WorkerViewModel

@Composable
fun ConvertImageScreen(modifier: Modifier = Modifier) {

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
                Text("Start Downloading and process")
            }

            Text("Download state: unknown")
            Text("Process state: unknown")
//            Image(
//                imageVector =
//                contentDescription = "empty"
//            )

        }
    }
}