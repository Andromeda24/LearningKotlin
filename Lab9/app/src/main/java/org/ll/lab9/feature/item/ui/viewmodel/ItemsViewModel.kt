package org.ll.lab9.feature.item.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import org.ll.lab9.feature.item.domain.ItemRepository
import org.ll.lab9.feature.item.ui.uistate.ItemListUiState

class ItemsViewModel(
    private val itemRepository: ItemRepository
): ViewModel() {

    // strategey for collecting flow

    val itemUIState : StateFlow<ItemListUiState> = itemRepository.getAllItems()
        .flowOn(Dispatchers.IO) // run this routine in the worker thread
        .distinctUntilChanged()
        .map { ItemListUiState(itemList = it) }
        .onStart { emit(ItemListUiState(isLoading = true)) }
        .catch { emit(ItemListUiState(error = it.message)) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            // keep loading for 5 seconds
            ItemListUiState()
        )

}