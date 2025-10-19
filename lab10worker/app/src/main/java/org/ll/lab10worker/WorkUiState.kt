package org.ll.lab10worker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.WorkInfo

data class WorkUiState(
    val state: WorkInfo.State? = null,
    val outputData: String?= null,
    val errorMessage: String? = null
) {


}

@Preview

@Composable
fun previewScreen (modifier: Modifier = Modifier) {
    WorkerScreen()
}