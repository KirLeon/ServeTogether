package com.codingub.hackathonproject.data.remote.responses

import com.codingub.hackathonproject.sdk.UserRole

data class AuthorizedUserResponse(
    val username : String,
    val phoneNumber: String,
    val userRole: UserRole,

    val authToken: String
)
