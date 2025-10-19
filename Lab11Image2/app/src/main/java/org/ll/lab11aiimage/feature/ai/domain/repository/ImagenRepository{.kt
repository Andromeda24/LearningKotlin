package org.ll.lab11aiimage.feature.ai.domain.repository

import android.graphics.Bitmap

interface ImagenRepository {
    suspend fun generateImage(prompt: String):Result<List<Bitmap>>
    }