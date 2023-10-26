package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.local.UserConfig
import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.data.remote.requests.DeleteAnnouncementRequest
import com.codingub.hackathonproject.data.remote.responses.GetAllAnnouncementsResponse
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementResponse
import com.codingub.hackathonproject.network.ServerResponse
import com.codingub.hackathonproject.sdk.AnnouncementStatus
import retrofit2.HttpException
import javax.inject.Inject

interface AnnouncementRepository {

    suspend fun getAllAnnouncements(): ServerResponse<List<Announcement>>
    suspend fun getAnnouncementById(id: Long): ServerResponse<Announcement>
    suspend fun addAnnouncement(request: AddAnnouncementRequest): ServerResponse<Unit>
    suspend fun deleteAnnouncement(request: DeleteAnnouncementRequest): ServerResponse<Unit>
}

class AnnouncementRepositoryImpl @Inject constructor(
    private val api: AppApi
) : AnnouncementRepository {


    override suspend fun getAllAnnouncements():ServerResponse<List<Announcement>> {
        return try {

            val result = api.getAllAnnouncements(token = UserConfig.getToken())
            ServerResponse.OK(result.announcements.map {
                it.toAnnouncement()
            })

        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }
    }

    override suspend fun getAnnouncementById(id: Long): ServerResponse<Announcement> {
        return try {

            val result = api.getAnnouncementById(token = UserConfig.getToken(), id)
            ServerResponse.OK(Announcement(
                id = result.id,
                title = result.title,
                content = result.content,
                status = AnnouncementStatus.valueOf(result.status),
                expirationDate = result.expirationDate,
                price = result.price
            ))

        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }
    }

    override suspend fun addAnnouncement(request: AddAnnouncementRequest): ServerResponse<Unit> {
        return try {
            api.addAnnouncement(token = UserConfig.getToken(), request)
            ServerResponse.OK(Unit)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404) {
                ServerResponse.NotFound()
            } else if (e.code() == 401) {
                ServerResponse.Unauthorized()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception) {
            ServerResponse.UnknownError()
        }
    }

    override suspend fun deleteAnnouncement(request: DeleteAnnouncementRequest): ServerResponse<Unit> {
        TODO("Not yet implemented")
    }
}