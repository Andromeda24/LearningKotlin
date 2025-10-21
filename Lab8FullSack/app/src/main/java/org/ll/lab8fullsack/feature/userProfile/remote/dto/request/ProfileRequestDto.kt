package org.ll.lab8fullsack.feature.userProfile.remote.dto.request

// this names should match the API definition if not , it should be anotated sith
// @SerializredName(backendName)
//val frontendName

data class ProfileRequestDto(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String, // Format: yyyy-MM-dd
    val email: String,
    val phoneNumber: String,
    val bio: String
)
/*
backend definition


public record ProfileRequestDto(
@NotBlank(message = "firstName cannot be blank/empty/null")
String firstName,
@NotBlank(message = "lastName cannot be blank/empty/null")
String lastName,
@NotNull(message = "dob cannot be null")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
LocalDate dateOfBirth,
@NotBlank(message = "email cannot be blank/empty/null")
@Email(message = "invalid email format")
String email,
@NotBlank(message = "phoneNumber cannot be blank/empty/null")
String phoneNumber,
@NotBlank(message = "bio cannot be blank/empty/null")
String bio
) */