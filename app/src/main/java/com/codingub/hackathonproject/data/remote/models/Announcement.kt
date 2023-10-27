package com.codingub.hackathonproject.data.remote.models

import com.codingub.hackathonproject.sdk.AnnouncementStatus
import java.util.Date

data class Announcement(
    val id: Long,
    val title: String,
    val content: String,
    val status: AnnouncementStatus,
    val expirationDate: String,
    val price: Long
)

data class ExtAnnouncement(
    val id: Long,
    val title: String,
    val content: String,
    val status: AnnouncementStatus,
    val expirationDate: String,
    val price: Long
)
