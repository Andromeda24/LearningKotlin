package org.ll.lab8fullsack.feature.userProfile.remote.dto.request

data class UserRequestDto(
    val username: String,
    val password: String,
    val profileRequestDto: ProfileRequestDto
)

/*
public record UserRequestDto(
@NotBlank(message = "username cannot be blank/empty/null")
String username,
@NotBlank(message = "username cannot be blank/empty/null")
@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[?*+!])[A-Za-z0-9?*+!]{4,8}$")
String password,
@NotNull(message = "profile cannot be null")
@Valid
ProfileRequestDto profileRequestDto
)
*/
