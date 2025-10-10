package org.ll.lab5_2.ui

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.ll.lab5_2.model.ABRepository
import org.ll.lab5_2.model.ABRepositoryImpl
import org.ll.lab5_2.data.AlphabetData
import org.ll.lab5_2.data.AlphabetData.alphabetData

class ABEViewModel(
    private val ABrepository : ABRepository
): ViewModel(){
    // AB referes to the data
    //private val ABdata = AlphabetData.alphabetData

    private val ABdata = ABrepository.getAlphabet()
    // initialize the state with the first value of the data
    private val _ABUiState = MutableStateFlow(
        value = ABEUIState(
            alphabet =ABdata[0].first,
            word = ABdata[0].second,
            isCompleted = true
        )
    )
    // Expose it as a read only state
    val currentState =_ABUiState.asStateFlow()
    // function for get the  next value
    fun nextAlphabet(){
        // version 1 direct implementation
    //val curIndex = alphabetData.indexOf(_ABUiState.value.alphabet to _ABUiState.value.word)

//        if (curIndex == -1){
//            val next = alphabetData[curIndex + 1]
//            _ABUiState.update {
//                it.copy(
//                    alphabet = next.first,
//                    word = next.word
//                )
//            }
//        } else  {
//            _ABUiState.update {
//                it.copy(
//                    alphabet = alphabetData[0].first,
//                    word = alphabetData[0].word
//                )
//            }
//        }

        // version 2 Use Repository

        val nextAB = ABrepository.getNextAlphabeth(_ABUiState.value.alphabet to _ABUiState.value.word)
        if (nextAB == ABdata.last()) {
            _ABUiState.update {
                it.copy(
                    alphabet = nextAB.first,
                    word = nextAB.second,
                    isCompleted = true
                )
            }
        }  else  {
             _ABUiState.update {
                it.copy(
                    alphabet = nextAB.first,
                    word = nextAB.second,
                    isCompleted = false
                )
            }
        }

    }

}