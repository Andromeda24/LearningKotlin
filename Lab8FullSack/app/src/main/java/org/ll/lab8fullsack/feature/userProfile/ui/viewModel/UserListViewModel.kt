package org.ll.lab8fullsack.feature.userProfile.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.ll.lab8fullsack.feature.userProfile.domain.UserRepository
import org.ll.lab8fullsack.feature.userProfile.remote.dto.response.UserResponseDto
import org.ll.lab8fullsack.feature.userProfile.ui.state.UserListUiState

class UserListViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userListUIState = MutableStateFlow(UserListUiState())
    val currentState = _userListUIState.asStateFlow()

    fun getAllUsers(){
        // launch acoroutine using ViewModel scope
        viewModelScope.launch{
            _userListUIState.update {
                it.copy(isLoading= true)
            }
            // fetch the users
            withContext(Dispatchers.IO){
                userRepository.listUsers()
                    .onSuccess { users: List<UserResponseDto> ->
                        _userListUIState.update {
                            it.copy(
                                isLoading= false,
                                error = null,
                                users = users
                            )
                        }

                    }
                    .onFailure { err->
                        _userListUIState.update {
                            it.copy(
                                isLoading= false,
                                error = err.message,
                                users = emptyList()
                            )
                        }
                    }

            }

        }
    }
}