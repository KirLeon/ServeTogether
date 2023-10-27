package com.codingub.hackathonproject.data.remote

import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.data.remote.requests.InviteKeyRequest
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.data.remote.responses.AuthorizedUserResponse
import com.codingub.hackathonproject.data.remote.responses.GetAllAnnouncementsResponse
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementResponse
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementsSearchResponse
import com.codingub.hackathonproject.data.remote.responses.GetExtAnnouncementResponse
import com.codingub.hackathonproject.data.remote.responses.GetGroupsSearchResponse
import com.codingub.hackathonproject.data.remote.responses.UserRoleResponse
import com.codingub.hackathonproject.network.EndPoints.ALL_ANNOUNCEMENTS
import com.codingub.hackathonproject.network.EndPoints.ANNOUNCEMENT
import com.codingub.hackathonproject.network.EndPoints.AUTHENTICATE
import com.codingub.hackathonproject.network.EndPoints.GROUPS
import com.codingub.hackathonproject.network.EndPoints.JOIN_GROUPS
import com.codingub.hackathonproject.network.EndPoints.LEAVE_GROUPS
import com.codingub.hackathonproject.network.EndPoints.MARKET
import com.codingub.hackathonproject.network.EndPoints.PROVIDE_INVITE_KEY
import com.codingub.hackathonproject.network.EndPoints.SIGNIN
import com.codingub.hackathonproject.network.EndPoints.SIGNUP
import retrofit2.http.Body
import retrofit2.http.DELETE
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
        @Header("registryToken") token: String,
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
    ) : GetExtAnnouncementResponse

    @GET("$ANNOUNCEMENT?title={title}")
    suspend fun getAnnouncementSearch(
        @Header("authToken") token: String,
        @Query("title") title: String
    ) : GetAnnouncementsSearchResponse

    @POST(ANNOUNCEMENT)
    suspend fun addAnnouncement(
        @Header("authToken") token: String,
        @Body request: AddAnnouncementRequest
    )

    @DELETE(ANNOUNCEMENT)
    suspend fun deleteAnnouncement(
        @Header("authToken") token: String,
        @Query("id") id: Long
    )

    /*
        Groups
     */

    @POST("$LEAVE_GROUPS?groupName={groupName}")
    suspend fun leaveGroup(
        @Query("groupName") groupName: String,
        @Header("authToken") token: String
    )

    @POST("$JOIN_GROUPS?groupName={groupName}")
    suspend fun joinGroup(
        @Query("groupName") groupName: String,
        @Header("authToken") token: String
    )

    //SEARCHING
    @GET("$GROUPS?groupName={groupName}")
    suspend fun getGroupsSearch(
        @Query("groupName") groupName: String,
        @Header("authToken") token: String
    ) : GetGroupsSearchResponse

    /*
        Market
     */

    @GET(MARKET)
    suspend fun getMarkets(
        @Header("authToken") token: String
    )

}