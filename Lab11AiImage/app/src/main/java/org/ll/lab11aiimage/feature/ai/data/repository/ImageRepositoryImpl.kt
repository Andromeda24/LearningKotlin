package org.ll.lab11aiimage.feature.ai.data.repository

import android.graphics.Bitmap
import com.google.firebase.ai.ImagenModel
import com.google.firebase.ai.type.ImagenInlineImage
import org.ll.lab11aiimage.feature.ai.domain.repository.ImagenRepository

class ImageRepositoryImpl(
    private val imageModel: ImagenModel
): ImagenRepository {
    override suspend fun generateImage(prompt: String): Result<List<Bitmap>> {
        return runCatching{
            imageModel.generateImages(prompt)
                .images
                .map({ image: ImagenInlineImage -> image.asBitmap()})
        }
    }
}