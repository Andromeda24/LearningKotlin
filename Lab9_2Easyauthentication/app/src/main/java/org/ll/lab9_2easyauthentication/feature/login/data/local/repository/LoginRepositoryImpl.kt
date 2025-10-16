package org.ll.lab9_2easyauthentication.feature.login.data.local.repository

import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import org.ll.lab9_2easyauthentication.feature.login.data.local.PreferencesDataSource
import org.ll.lab9_2easyauthentication.feature.login.domain.model.UserCredentials
import org.ll.lab9_2easyauthentication.feature.login.domain.repository.LoginRepository

class LoginRepositoryImpl (
    val preferencesDataSource: PreferencesDataSource
): LoginRepository {
    override suspend fun saveUserCredentials(userCredentials: UserCredentials) {
        preferencesDataSource.saveUserCredentials(userCredentials)
    }

    override fun getUserCredentials(): Flow<UserCredentials?> {
        return preferencesDataSource.getUserCredentials()
    }


}