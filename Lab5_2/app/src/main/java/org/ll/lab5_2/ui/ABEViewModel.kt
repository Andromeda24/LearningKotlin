package org.ll.lab5_2.ui

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.ll.lab5_2.data.AlphabetData
import org.ll.lab5_2.data.AlphabetData.alphabetData

class ABEViewModel: ViewModel(){
    // AB referesto the data
    private val ABdata = AlphabetData.alphabetData
    // initialize the state with the first value of the data
    private val _ABUiState = MutableStateFlow(
        value = ABEUIState(
            alphabet =ABdata[0].first,
            word = ABdata[0].second,
            isCompleted = true
        )
    )
    // Expose it as a red only state
    val currentState =_ABUiState.asStateFlow()
    // function for get the  next value
    fun nextAlphabet(){
        val curIndex = alphabetData.indexOf(_ABUiState.value.alphabet to _ABUiState.value.word)
        if (curIndex == -1){
            val next = alphabetData[curIndex + 1]
            _ABUiState.update {
                it.copy(
                    alphabet = next.first,
                    word = next.word
                )
            }
        } else  {
            _ABUiState.update {
                it.copy(
                    alphabet = alphabetData[0].first,
                    word = alphabetData[0].word
                )
            }
        }
    }

}