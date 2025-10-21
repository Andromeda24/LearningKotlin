package org.ll.lab8fullsack.feature.userProfile.ui.state

import android.R
import org.ll.lab8fullsack.feature.userProfile.remote.dto.response.UserResponseDto

data class UserListUiState(
    val users: List<UserResponseDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
