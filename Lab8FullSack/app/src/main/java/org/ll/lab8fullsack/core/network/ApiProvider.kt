package org.ll.lab8fullsack.core.network

import org.ll.lab8fullsack.feature.userProfile.remote.api.UserAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            // server address
            .baseUrl("http://10.200.3.200:8080/api/v1/") // end with slash
            // convert the Json Objects in Kotlin dataObjects
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val userApiService: UserAPIService by lazy {
        retrofit.create<UserAPIService>(UserAPIService::class.java)
    }
}
// the first time this object is used, it creates this Object
// we use it ApiProvider.method

// two ways of define it:
//private val retrofit: Retrofit by lazy {
//private val retrofit: Lazy<Retrofit> = lazy {