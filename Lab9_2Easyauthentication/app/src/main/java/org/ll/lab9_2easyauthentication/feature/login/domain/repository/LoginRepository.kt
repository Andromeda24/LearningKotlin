package org.ll.lab9_2easyauthentication.feature.login.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ll.lab9_2easyauthentication.feature.login.domain.model.UserCredentials

interface LoginRepository {
    suspend fun saveUserCredentials(userCredentials: UserCredentials)
    fun getUserCredentials(): Flow<UserCredentials?>
}