package org.ll.lab10worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MyCoroutineWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker( // it does not block the thread

    context, workerParameters

) {
    override suspend fun doWork(): Result {
        // return Return.success() or
        // return Return.failure

        return runCatching {

                // receive inputData
                val program = inputData.getString("program")
                val duration = inputData.getInt("duration", defaultValue = 0)
                val course = inputData.getStringArray("courses")
                val message = when (program){
                    "MS"-> "enrolled in MS"
                    "MCA" -> "enrolled in MCA"
                    else -> "not enrolled"
                }

                val output = workDataOf(
                    "output_data" to message
                )
            Log.i("CoroutineWorker", output.toString())
                Result.success(output)
            }.fold(
                onSuccess = { it} ,
                onFailure = {
                    Result.failure()
                    // it can retry cording to the
                }
            )

    }


}