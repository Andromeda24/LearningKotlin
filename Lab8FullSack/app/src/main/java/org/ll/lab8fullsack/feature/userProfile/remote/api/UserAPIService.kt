package org.ll.lab8fullsack.feature.userProfile.remote.api

import org.ll.lab8fullsack.feature.userProfile.remote.dto.request.UserRequestDto
import org.ll.lab8fullsack.feature.userProfile.remote.dto.response.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPIService {
    @POST("users")
    suspend fun createUser(userRequestDto: UserRequestDto): UserResponseDto

    @GET("users")
    suspend fun getUsers(): Result<List<UserResponseDto>>

}

/*
Definition in the backend

 //create a user
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);//201
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtos = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtos);
    }
 */