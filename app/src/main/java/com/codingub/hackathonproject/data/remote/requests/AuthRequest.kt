package com.codingub.hackathonproject.data.remote.requests

data class RegisterDataRequest(
    val inviteCode: String = "",
    val username: String,
    val phoneNumber: String,
    val password: String
)

data class InviteCodeRequest(
    val inviteCode: String
)

data class LoginDataRequest(
    val username: String,
    val password: String
)