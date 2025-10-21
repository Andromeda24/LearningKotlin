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

/*

Retrofit is the library (for javaand android) that alows API comunication. it authomatically writtes implements the interface (so it HAS to bean interface)

Retrofit API definiion looks like that
@GET @POST  define the callingmathod
@Body to besent in the ody
@path ???
{} to be replaced by avalue
@query   to be send in querystring 

interface UserApiService {
@POST("users")
suspend fun createUser(@Body userRequestDto: UserRequestDto): UserResponseDto
@GET("users")
suspend fun getUsers(): List<UserResponseDto>
@GET("users/{id}")
suspend fun getUserById(@Path("id") id: Int): UserResponseDto
@GET("users")
suspend fun getUsersSortedByDescending(@Query("sort") sortOrder: String = "desc"): List<UserResponseDto>
@GET("users")
suspend fun getFilteredUsers(
@Query("sort") sortOrder: String = "desc",
@Query("page") page: Int = 1,
@Query("limit") limit: Int = 10,
@Query("role") role: String? = null
): List<UserResponseDto>
}
GET /users?sort=asc&page=1&limit=10&role=admin


example of showing pictures using Retrofit
https://kotlinlang.org/docs/serialization.html#example-json-serialization
*/