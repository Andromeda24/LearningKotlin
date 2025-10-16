package org.ll.lab9_2easyauthentication.feature.login.data.local

import androidx.datastore.preferences.core.stringPreferencesKey

// define the keys thet the app will use internal name -> storage name
object DataStoreKeys {
    val USER_NAME = stringPreferencesKey("USER_NAME")
    val PASSWORD = stringPreferencesKey("PASSWORD")
}