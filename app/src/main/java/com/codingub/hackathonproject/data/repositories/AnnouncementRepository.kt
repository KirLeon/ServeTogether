package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.data.remote.requests.DeleteAnnouncementRequest
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementResponse
import com.codingub.hackathonproject.network.ServerResponse
import javax.inject.Inject

interface AnnouncementRepository {

    suspend fun getAnnouncements() : ServerResponse<GetAnnouncementResponse>
    suspend fun addAnnouncement(request: AddAnnouncementRequest) : ServerResponse<Unit>
    suspend fun deleteAnnouncement(request: DeleteAnnouncementRequest) : ServerResponse<Unit>
}

class AnnouncementRepositoryImpl @Inject constructor(
) : AnnouncementRepository{


    override suspend fun getAnnouncements(): ServerResponse<GetAnnouncementResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun addAnnouncement(request: AddAnnouncementRequest): ServerResponse<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAnnouncement(request: DeleteAnnouncementRequest): ServerResponse<Unit> {
        TODO("Not yet implemented")
    }
}