package com.codingub.hackathonproject.data.remote.requests

data class RegisterDataRequest(
    val username: String,
    val phoneNumber: String,
    val password: String,
    val inviteKey: String
)

data class InviteKeyRequest(
    val inviteKey: String
)

data class LoginDataRequest(
    val username: String,
    val password: String
)