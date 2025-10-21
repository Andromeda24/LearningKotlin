package org.ll.lab8fullsack.feature.userProfile.remote.dto.response

data class ProfileResponseDto(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val email: String,
    val phoneNumber: String,
    val bio: String
)