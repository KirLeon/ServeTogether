package com.codingub.hackathonproject.data.remote.requests

data class AddAnnouncementRequest(
    val content: String,
    val price: Long,
    val title: String
    )

data class DeleteAnnouncementRequest(
    val test: String = "",
    )