package org.ll.lab10worker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

private const val UNIQUE_WORKNAME = "my_work"
class WorkerViewModel(
    private val workManager : WorkManager
): ViewModel(
) {
    private val _workUiState = MutableStateFlow(WorkUiState())

    val workUiState: StateFlow<WorkUiState> = _workUiState.asStateFlow()

    init { // update the UI State with the work status
        viewModelScope.launch {
            workManager.getWorkInfosForUniqueWorkFlow(UNIQUE_WORKNAME)
                .collect{
                    workInfos: List<WorkInfo> ->
                    val workInfo: WorkInfo? = workInfos.firstOrNull()
                    _workUiState.update {
                        it.copy(
                            state= workInfo?.state
                        )
                    }
                }
        }
    }
    fun startWork(){
    // Create input data in the form of list of pairs

        // create the work request
        // other way
        //val oneTimeWorkRequest: OneTimeWorkRequest = OneTimeWorkRequest()
        //    .Builder(MyWorker::class.java)

        val oneTimeWorkRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
           .setConstraints(
               Constraints.Builder()
                    .setRequiresCharging(false)
                    .setRequiresBatteryNotLow(true)
                    .setRequiredNetworkType(NetworkType.UNMETERED)
//             be  careful. use Worker Constraints, not composable constraints
                   .build() // build the constraints
           ).build() // build the worker
        // run it
        workManager.enqueueUniqueWork(
            UNIQUE_WORKNAME,
            ExistingWorkPolicy.KEEP,
            oneTimeWorkRequest)


    }

    fun startAsyncWork(){
        // Create input data in the form of list of pairs
        val inputData: Data = workDataOf(
            "program" to "MS",
            "duration" to "3",
            "course" to arrayOf ("MPP","MDP")
        )
        // create the work request
        // other way
        //val oneTimeWorkRequest: OneTimeWorkRequest = OneTimeWorkRequest()
        //    .Builder(MyWorker::class.java)

        val oneTimeWorkRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder< MyCoroutineWorker>()
            .setConstraints(Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED) // only wifi. do not consume data
                .build())
            .setInputData(inputData)
            .setBackoffCriteria(
                backoffPolicy = BackoffPolicy.LINEAR,
                backoffDelay = 10,
                timeUnit = TimeUnit.MINUTES,
                // if fails. retry every 10 minutes
                // if BackoffPolicy.EXPONENTIAL increases the gap on each try
            )
            .build()
        // run it
        // )
        workManager.enqueueUniqueWork(
            UNIQUE_WORKNAME,
            ExistingWorkPolicy.KEEP,
            oneTimeWorkRequest)


    }

    fun cancelWork(){
        workManager.cancelUniqueWork(UNIQUE_WORKNAME)
    }
}

// Note. all of this can also be done using UUID instead od Unique Name

// lateinit wordRequestID: UUID
//wordRequestID = oneTimePassword.getWorkId
//workManager.getWorkInfosForUUID(wordRequestID).collect()