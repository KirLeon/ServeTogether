package com.codingub.hackathonproject.data.remote.models.users

data class Volunteer(
    val username: String,
    val password: String,
    val phoneNumber: String,
    val coins: Long = 0
)
