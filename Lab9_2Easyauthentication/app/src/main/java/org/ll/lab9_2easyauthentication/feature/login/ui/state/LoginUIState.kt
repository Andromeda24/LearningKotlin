package org.ll.lab9_2easyauthentication.feature.login.ui.state

import org.ll.lab9_2easyauthentication.feature.login.domain.model.UserCredentials

data class LoginUIState(
    val username : String,
    val password: String
)
