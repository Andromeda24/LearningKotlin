package org.ll.lab9.feature.item.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ll.lab9.core.database.entity.Item
import org.ll.lab9.feature.item.domain.ItemRepository
import org.ll.lab9.feature.item.ui.uistate.ItemDetailUiState

class ItemDetailViewModel (
    private val itemRepository: ItemRepository
): ViewModel() {
    private val _itemDetailUiState = MutableStateFlow(ItemDetailUiState.Empty)

    val itemDetailUiState = _itemDetailUiState.asStateFlow()

    fun updateItemName(name: String) {
        _itemDetailUiState.update {
            it.copy(name = name)
        }
    }

    fun updateItemPrice(price: String) {
        _itemDetailUiState.update {
            it.copy(price = price)
        }
    }

    fun updateItemQuantoty(quantity: String) {
        _itemDetailUiState.update {
            it.copy(quantity = quantity)
        }
    }

    fun updateItemDescription(description: String) {
        _itemDetailUiState.update {
            it.copy(description = description)
        }
    }

    fun insertItem() {
        viewModelScope.launch {
            _itemDetailUiState.update {
                it.copy(isLoading = true)
            }
            val result = withContext(Dispatchers.IO) {
                itemRepository.insertItem(
                    Item(
                        name = itemDetailUiState.value.name,
                        price = itemDetailUiState.value.price.toDouble(),
                        quantity = itemDetailUiState.value.quantity.toInt()
                    )
                )
            }
            result.onSuccess {
                _itemDetailUiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccessful = true
                    )
                }
            }.onFailure { error ->
                _itemDetailUiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccessful = false,
                        errorMessage = error.message
                    )
                }

            }

        }
    }
}