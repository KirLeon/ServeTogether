package com.codingub.hackathonproject.data.remote.responses

import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.data.remote.models.ExtAnnouncement
import com.codingub.hackathonproject.sdk.AnnouncementStatus
import com.codingub.hackathonproject.utils.DateUtil
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
            DateUtil.dateToString(expirationDate),
            price
        )
    }

}

data class GetExtAnnouncementResponse(
    val id: Long,
    val title: String,
    val content: String,
    val status: String,
    val expirationDate: Date,
    val price: Long
) {

    fun toExtAnnouncement() : ExtAnnouncement {
        return ExtAnnouncement(
            id,
            title,
            content,
            AnnouncementStatus.valueOf(status),
            DateUtil.dateToString(expirationDate),
            price
        )
    }

}

data class GetAllAnnouncementsResponse(
    val announcements: List<GetAnnouncementResponse>
)

data class GetAnnouncementsSearchResponse(
   val announcements: List<GetAnnouncementResponse>
)
