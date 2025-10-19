package org.ll.lab11aiimage.feature.ai.data.repository

import android.graphics.Bitmap
import android.util.Log
import com.google.firebase.ai.ImagenModel
import com.google.firebase.ai.type.ImagenGenerationResponse
import com.google.firebase.ai.type.ImagenInlineImage
import org.ll.lab11aiimage.feature.ai.domain.repository.ImagenRepository

class ImageRepositoryImpl(
    private val imageModel: ImagenModel
): ImagenRepository {
    override suspend fun generateImage(prompt: String): Result<List<Bitmap>> {
        Log.i("ImageRepositoryImpl", "generateImage() called with prompt: $prompt")
        return runCatching{
//            imageModel.generateImages(prompt)
//                .images
//                .map({ image: ImagenInlineImage -> image.asBitmap()})
            val myImages : ImagenGenerationResponse<ImagenInlineImage> = imageModel.generateImages(prompt)
            Log.i("ImageRepositoryImpl", "generateImage() onSuccess ${myImages.images.size}")
            myImages.images.map({ image: ImagenInlineImage -> image.asBitmap()})
        }
    }
}