package org.ll.lab9.feature.item.ui.uistate

data class ItemDetailUiState (
    val name: String = "",
    val description: String = "",
    val price: String = "",
    val quantity: String = "",
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val errorMessage: String? = null
){
    companion object{
        val Empty = ItemDetailUiState()
    }
}