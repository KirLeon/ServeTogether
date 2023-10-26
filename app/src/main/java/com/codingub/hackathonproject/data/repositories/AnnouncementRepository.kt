package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.local.UserConfig
import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.data.remote.models.ExtAnnouncement
import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.network.ServerResponse
import com.codingub.hackathonproject.sdk.AnnouncementStatus
import retrofit2.HttpException
import javax.inject.Inject

interface AnnouncementRepository {

    suspend fun getAllAnnouncements(): ServerResponse<List<Announcement>>
    suspend fun getAnnouncementById(id: Long): ServerResponse<ExtAnnouncement>
    suspend fun addAnnouncement(request: AddAnnouncementRequest): ServerResponse<Unit>
    suspend fun deleteAnnouncement(id: Long): ServerResponse<Unit>
    suspend fun getAnnouncementSearch(title: String): ServerResponse<List<Announcement>>

}

class AnnouncementRepositoryImpl @Inject constructor(
    private val api: AppApi
) : AnnouncementRepository {

    override suspend fun getAllAnnouncements(): ServerResponse<List<Announcement>> {
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

    override suspend fun getAnnouncementById(id: Long): ServerResponse<ExtAnnouncement> {
        return try {
            val result =
                api.getAnnouncementById(token = UserConfig.getToken(), id).toExtAnnouncement()
            ServerResponse.OK(result)
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

    override suspend fun deleteAnnouncement(id: Long): ServerResponse<Unit> {
        return try {
            api.deleteAnnouncement(token = UserConfig.getToken(), id)
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

    override suspend fun getAnnouncementSearch(title: String): ServerResponse<List<Announcement>> {
        return try {
            val result = api.getAnnouncementSearch(token = UserConfig.getToken(), title)
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
}