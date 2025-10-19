package org.ll.lab11aiimage.feature.ai.ui.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ll.lab11aiimage.feature.ai.domain.repository.ImagenRepository
import org.ll.lab11aiimage.feature.ai.ui.state.ImageGenUiState

class ImageGenViewModel(
    private val imageRepository: ImagenRepository
) : ViewModel() {

    private val _imageGenUiState = MutableStateFlow(ImageGenUiState())
    val currentState = _imageGenUiState.asStateFlow()

    fun onPromptChange(prompt: String){
        _imageGenUiState.update {
            it.copy(
                prompt = prompt
            )

        }
    }

    fun generateImage() {
        viewModelScope.launch {
            _imageGenUiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            val result = withContext(Dispatchers.IO) {
                imageRepository.generateImage(prompt = currentState.value.prompt)
            }
            result.onSuccess {images->
                _imageGenUiState.update {
                    it.copy(
                        myImages = images,
                        isLoading = false,
                        errorMessage = null
                    )
                }
            }.onFailure { throwable ->
                _imageGenUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = throwable.message
                    )
                }
            }
        }
    }
}
