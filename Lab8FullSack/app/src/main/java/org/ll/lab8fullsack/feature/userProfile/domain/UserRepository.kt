package org.ll.lab8fullsack.feature.userProfile.domain

import org.ll.lab8fullsack.feature.userProfile.remote.dto.request.UserRequestDto
import org.ll.lab8fullsack.feature.userProfile.remote.dto.response.UserResponseDto

interface UserRepository {
    suspend fun createUser(userRequestDto: UserRequestDto): Result<UserResponseDto>
    suspend fun listUsers (): Result<List<UserResponseDto>>

}