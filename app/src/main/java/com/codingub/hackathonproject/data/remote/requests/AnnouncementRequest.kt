package com.codingub.hackathonproject.data.remote.requests

data class AddAnnouncementRequest(
    val title: String,
    val content: String,
    val reward: Long
    )
