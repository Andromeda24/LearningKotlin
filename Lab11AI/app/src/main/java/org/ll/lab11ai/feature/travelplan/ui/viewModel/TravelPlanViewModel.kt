package org.ll.lab11ai.feature.travelplan.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ll.lab11ai.feature.travelplan.domain.repository.TravelPlanRepository
import org.ll.lab11ai.feature.travelplan.ui.state.TravelPlanUiState

class TravelPlanViewModel(
    travelPlanRepository : TravelPlanRepository?
): ViewModel() {

    private val _travelPlanUiState = MutableStateFlow(TravelPlanUiState(prompt =  "", error = null))
    val travelPlanUiState = _travelPlanUiState.asStateFlow()

    fun onPromptChange(prompt: String){
        _travelPlanUiState.update {
            it.copy (prompt = prompt)
        }
    }

    fun generateTravelPlan(){
        viewModelScope.launch {
            _travelPlanUiState.update {
                it.copy (
                    prompt = travelPlanUiState.value.prompt,
                    error  = null)

            }
        }
    }
}