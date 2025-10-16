package org.ll.lab9_2easyauthentication.feature.login.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ll.lab9_2easyauthentication.feature.login.domain.model.UserCredentials
import org.ll.lab9_2easyauthentication.feature.login.domain.repository.LoginRepository
import org.ll.lab9_2easyauthentication.feature.login.ui.state.LoginUIState

class LoginViewModel (
    private val loginRepository: LoginRepository
): ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUIState("",""))

    val loginUIState : StateFlow<LoginUIState> = _loginUiState.asStateFlow()

    init {
        // retrive the loged user at startup
        viewModelScope.launch {
            var loginCredential : Flow<UserCredentials?> = loginRepository.getUserCredentials()
            // DO NOT USE loginRepository.collect()
            val existingCredentials = loginCredential.firstOrNull()
            if (existingCredentials?.username == "admin" &&
                existingCredentials?.password == "admin"){
                Log.i("LoginVM", "User already logged in")
        }
        }
    }

    fun onUsernameChange(username : String){
        _loginUiState.update {
            it.copy(username = username)
        }
    }

    fun onPasswordChange(password : String){
        _loginUiState.update {
            it.copy(password = password)
        }
    }

    fun login(){
        viewModelScope.launch {
            val username = loginUIState.value.username
            val password = loginUIState.value.password
            if (username == "admin" && password == "admin"){
                loginRepository.saveUserCredentials(UserCredentials(username,password))
                Log.i ("LoginVM", "Login succesfull")
            } else {
                Log.i ("LoginVM", "Login failsd")
            }
        }
    }


}