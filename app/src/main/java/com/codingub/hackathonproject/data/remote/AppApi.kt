package com.codingub.hackathonproject.data.remote

import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.data.remote.requests.DeleteAnnouncementRequest
import com.codingub.hackathonproject.data.remote.requests.InviteKeyRequest
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.data.remote.responses.AuthorizedUserResponse
import com.codingub.hackathonproject.data.remote.responses.GetAllAnnouncementsResponse
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementResponse
import com.codingub.hackathonproject.data.remote.responses.UserRoleResponse
import com.codingub.hackathonproject.network.EndPoints.ALL_ANNOUNCEMENTS
import com.codingub.hackathonproject.network.EndPoints.ANNOUNCEMENT
import com.codingub.hackathonproject.network.EndPoints.AUTHENTICATE
import com.codingub.hackathonproject.network.EndPoints.MARKET
import com.codingub.hackathonproject.network.EndPoints.PROVIDE_INVITE_KEY
import com.codingub.hackathonproject.network.EndPoints.SIGNIN
import com.codingub.hackathonproject.network.EndPoints.SIGNUP
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AppApi{

    /*
        Authentication
     */

    @POST(SIGNUP)
    suspend fun signUp(
        @Body request : RegisterDataRequest
    )

    //нужно здесь получать токен
    @POST(SIGNIN)
    suspend fun signIn(
        @Body request : LoginDataRequest
    ): AuthorizedUserResponse

    @GET(AUTHENTICATE)
    suspend fun authenticate(
        @Header("authToken") token: String
    )

    @POST(PROVIDE_INVITE_KEY)
    suspend fun provideInviteKey(
        @Body request : InviteKeyRequest
    ) : UserRoleResponse

    /*
        Announcement
     */

    @GET(ALL_ANNOUNCEMENTS)
    suspend fun getAllAnnouncements(
        @Header("authToken") token: String
    ) : GetAllAnnouncementsResponse


    @GET("$ANNOUNCEMENT?id={id}")
    suspend fun getAnnouncementById(
        @Header("authToken") token: String,
        @Query("id") id: Long
    ) : GetAnnouncementResponse

    @POST(ANNOUNCEMENT)
    suspend fun addAnnouncement(
        @Header("authToken") token: String,
        @Body request: AddAnnouncementRequest
    )

    //test
    @POST(ANNOUNCEMENT)
    suspend fun deleteAnnouncement(
        @Header("authToken") token: String,
        @Body request: DeleteAnnouncementRequest
    )



    /*
        Market
     */

    @GET(MARKET)
    suspend fun getMarkets(
        @Header("authToken") token: String
    )

}