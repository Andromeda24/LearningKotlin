package org.ll.lab9_2easyauthentication.feature.login.data.local

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.ll.lab9_2easyauthentication.feature.login.domain.model.UserCredentials

class PreferencesDataSource (
    private val context: Context
){
    // handles the persistence of user data (saving and reading
    suspend fun saveUserCredentials( user: UserCredentials){
        // get the Data in user and write it into datastore
        context.dataStore.edit {
            preferences: MutablePreferences ->
            preferences[DataStoreKeys.USER_NAME] = user.username
            preferences[DataStoreKeys.PASSWORD] = user.password
        }

    }
    fun getUserCredentials(): Flow<UserCredentials?> {
        return context.dataStore.data
            .map {
                preferences ->
                val username = preferences[DataStoreKeys.USER_NAME]
                val password = preferences[DataStoreKeys.PASSWORD]
                if (username != null && password != null){
                    UserCredentials(username, password)
                } else {
                    null
                }
            }.distinctUntilChanged()
    }
}

