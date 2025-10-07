package org.ll.lab5.ui

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// it was created as CLASS . it's only one View model per screen
class CounterViewModel: ViewModel() {
    private val _counterUIState = MutableStateFlow(value= CounterUIState(count=0,isLoading = false))
    // in this case the state is is stored in an object, not a primitive type. then, use MutableStateFlow
    val counterUiState = _counterUIState.asStateFlow() //it expresses the data as readonly

    fun increment(){
        _counterUIState.update {
            // it.copy(count = it-1)  // short version
            // longversion
            state -> state.copy(count = state.count +1, errorMessage = null)

            //_counterUIState is unmutable so we need to made a copy
        }
        // this code means:
        // create a copy of the current state (it), changing the counter and set it as the new value of _counterUIState

    }

    fun decrement(){
        if (counterUiState.value.count == 0) { // use the Flow to access the current value
            _counterUIState.update { state ->
                state.copy(
                    count = state.count,
                    errorMessage = "Cannot decrement below 0"
                )
            }
        } else{
            _counterUIState.update { state ->
                state.copy(
                    count = state.count - 1,
                    errorMessage = null
                )
            }
        }
    }
}