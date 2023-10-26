package com.codingub.hackathonproject.data.remote.models

import java.util.Date

data class Announcement(
    val title: String,
    val content: String,
    val expirationDate: Date,
    val price: Long,
    val status: Long //AnnouncementStatus
)
