package org.ll.lab11aiimage.core.ai

import com.google.firebase.Firebase
import com.google.firebase.ai.ImagenModel

import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.ImagenAspectRatio
import com.google.firebase.ai.type.ImagenGenerationConfig
import com.google.firebase.ai.type.ImagenImageFormat
import com.google.firebase.ai.type.ImagenPersonFilterLevel
import com.google.firebase.ai.type.ImagenSafetyFilterLevel
import com.google.firebase.ai.type.ImagenSafetySettings

object GenerativeModelService {
    @Volatile
    private var imageGenModel: ImagenModel? = null
    fun getImageGenModel(): ImagenModel{
        val config = ImagenGenerationConfig (
            numberOfImages = 2,
            aspectRatio = ImagenAspectRatio.LANDSCAPE_16x9,
            imageFormat = ImagenImageFormat.jpeg(compressionQuality = 100),
            addWatermark = false
        )

// Initialize the Gemini Developer API backend service
// For Vertex AI use Firebase.ai(backend = GenerativeBackend.vertexAI())
        return imageGenModel?: synchronized(this){
            val model = Firebase.ai(backend = GenerativeBackend.googleAI()).imagenModel(
                modelName = "imagen-4.0-generate-001",
                generationConfig = config,
                safetySettings = ImagenSafetySettings(
                    safetyFilterLevel = ImagenSafetyFilterLevel.BLOCK_LOW_AND_ABOVE,
                    personFilterLevel = ImagenPersonFilterLevel.BLOCK_ALL
                )
            )
            imageGenModel = model
            model
        }

    }


}