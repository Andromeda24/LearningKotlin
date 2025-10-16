package org.ll.lab9_2easyauthentication.feature.login.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab9_2easyauthentication.feature.login.data.local.PreferencesDataSource
import org.ll.lab9_2easyauthentication.feature.login.data.local.repository.LoginRepositoryImpl
import org.ll.lab9_2easyauthentication.feature.login.ui.viewModel.LoginViewModel

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val loginViewModel : LoginViewModel = viewModel {
        LoginViewModel(LoginRepositoryImpl(PreferencesDataSource(context)))
    }

    val loginUIState by loginViewModel.loginUIState.collectAsStateWithLifecycle()
    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                value = loginUIState.username,
                onValueChange = {loginViewModel.onUsernameChange(it)},
                label = { Text(text = "username")}
            )

            OutlinedTextField(
                value = loginUIState.password,
                onValueChange = {loginViewModel.onPasswordChange(it)},
                label = { Text(text = "password")}
            )
            Button(
                onClick= { loginViewModel.login() }
            ){
                Text("login")
            }
        }


    }

}