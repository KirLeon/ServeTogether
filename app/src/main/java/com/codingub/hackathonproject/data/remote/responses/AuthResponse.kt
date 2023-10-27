package com.codingub.hackathonproject.data.remote.responses

import com.codingub.hackathonproject.data.remote.models.VolunteerGroup

data class AuthorizedUserResponse(
    val username : String,
    val phoneNumber: String,
    val group: VolunteerGroup,
    val coins: Long = 0,
    val authToken: String
)

data class UserRoleResponse(
    val role: String
)
