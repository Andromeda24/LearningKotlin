package org.ll.lab8fullsack.feature.userProfile.remote.repository

import org.ll.lab8fullsack.feature.userProfile.remote.api.UserAPIService
import org.ll.lab8fullsack.feature.userProfile.remote.dto.request.UserRequestDto
import org.ll.lab8fullsack.feature.userProfile.remote.dto.response.UserResponseDto
import org.ll.lab8fullsack.feature.userProfile.domain.UserRepository
import retrofit2.http.Body

class UserRepositoryImpl(private val service : UserAPIService):  UserRepository {

    override suspend fun createUser(@Body userRequestDto: UserRequestDto)
    : Result<UserResponseDto> { // we use result because it's a susended  mathod
        return runCatching { // the service can throw an exception
            service.createUser(userRequestDto)
        }

    }

    override suspend fun listUsers(): Result<List<UserResponseDto>> {
        return service.getUsers()
    }
}