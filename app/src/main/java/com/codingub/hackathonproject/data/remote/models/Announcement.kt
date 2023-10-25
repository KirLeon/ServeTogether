package com.codingub.hackathonproject.data.remote.models

data class Announcement(
    val id: Long,
    val status: String,
    val content: String,
    val reward: Long,
    //val exparationDate: String,
    val groupId: Long
)
