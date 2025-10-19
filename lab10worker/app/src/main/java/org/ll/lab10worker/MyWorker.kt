package org.ll.lab10worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(
    context: Context,
    workerParameters: WorkerParameters
): Worker( // or CoroutineWorker. Worker works synchonously on a backgroud thread. means that block the current thread

    context, workerParameters

) {
    override fun doWork(): Result {
        // return Return.success() or
        // return Return.failure

        return runCatching {
                for (i in 1..20){
                    Log.i("MyWorker", "iteration number  $i" )

                }
            }
            .fold(
                onSuccess = { Result.success() } ,
                onFailure = { Result.failure() }
            )

    }
}