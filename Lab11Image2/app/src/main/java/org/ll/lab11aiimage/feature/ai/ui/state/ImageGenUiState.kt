package org.ll.lab11aiimage.feature.ai.ui.state

import android.graphics.Bitmap

data class ImageGenUiState(
    val isLoading: Boolean = false,
    val myImages: List<Bitmap> = emptyList(),
    val prompt: String = "",
    val errorMessage: String? = null
)
