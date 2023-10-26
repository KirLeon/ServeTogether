package com.codingub.hackathonproject.data.remote.responses

import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.sdk.AnnouncementStatus
import java.util.Date

data class GetAnnouncementResponse(
    val id: Long,
    val title: String,
    val content: String,
    val status: String,
    val expirationDate: Date,
    val price: Long
) {

    fun toAnnouncement() : Announcement{
        return Announcement(
            id,
            title,
            content,
            AnnouncementStatus.valueOf(status),
            expirationDate,
            price
        )
    }

}

data class GetAllAnnouncementsResponse(
    val announcements: List<GetAnnouncementResponse>
)
