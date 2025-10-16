package org.ll.lab9.feature.item.ui.uistate

import org.ll.lab9.core.database.entity.Item

data class ItemListUiState(
    val itemList: List<Item> = listOf(),
    val error: String? = null,
    val isLoading: Boolean = false
){

}
