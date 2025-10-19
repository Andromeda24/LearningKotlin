package org.ll.lab11ai.core.ai

import android.content.Context
import android.util.Log
import com.google.ai.edge.aicore.DownloadCallback
import com.google.ai.edge.aicore.DownloadConfig
import com.google.ai.edge.aicore.GenerativeAIException
import com.google.ai.edge.aicore.GenerativeModel
import com.google.ai.edge.aicore.generationConfig


object GenerativeModelService {
    @Volatile  //once the object is initialized, everyone canaccess it
    private var model: GenerativeModel? = null

    fun getModel(context: Context): GenerativeModel {
        val generationConfig = generationConfig {
            this.context = context.getApplicationContext() // required
            temperature = 0.2f
            topK = 16
            maxOutputTokens = 256
        }
        val downloadConfig = DownloadConfig(
         downloadCallback =  object : DownloadCallback {
             override fun onDownloadDidNotStart(e: GenerativeAIException) {
                 super.onDownloadDidNotStart(e)
                 Log.i("AI" , e.toString()) // overlap all the functions just for debugging
             }
         }
        )

        return model ?: synchronized(this) {
            val generativeModel = GenerativeModel(
                generationConfig = generationConfig,
                downloadConfig = downloadConfig // optional
            )
            model = generativeModel
            generativeModel
        }
    }

}
