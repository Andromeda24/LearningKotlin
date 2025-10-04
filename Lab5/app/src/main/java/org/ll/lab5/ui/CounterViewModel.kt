package org.ll.lab5.ui

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CounterViewModel: ViewModel {
    private val _counterUIState = MutableStateFlow(value= CounterUIState())
    // in this case the state is is stored in an object, not a primitive type. then, use MutableStateFlow
    val counterUiState = _counterUIState.asStateFlow() //express the data as readonly

    fun increment(){
        _counterUIState.update {
            // it.copy(count = it-1)  // short version
            // longversion
            state -> _counterUIState.copy(count = state.count +1)

            //_counterUIState is unmutable so we need to made a copy
        }
    }

    fun decrement(){
        _counterUIState.update {
            // it.copy(count = it-1)  // short version
            // longversion
                state -> _counterUIState.copy(count = state.count -1)

            //_counterUIState is unmutable so we need to made a copy
        }
    }
}