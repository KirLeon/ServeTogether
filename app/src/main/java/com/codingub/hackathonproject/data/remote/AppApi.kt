package com.codingub.hackathonproject.data.remote

import com.codingub.hackathonproject.data.remote.requests.InviteKeyRequest
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.data.remote.responses.AuthorizedUserResponse
import com.codingub.hackathonproject.network.EndPoints.AUTHENTICATE
import com.codingub.hackathonproject.network.EndPoints.PROVIDE_INVITE_KEY
import com.codingub.hackathonproject.network.EndPoints.SIGNIN
import com.codingub.hackathonproject.network.EndPoints.SIGNUP
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

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
    ) : AuthorizedUserResponse

    @GET(AUTHENTICATE)
    suspend fun authenticate(
        @Header("Authorization") authToken: String
    )

    @POST(PROVIDE_INVITE_KEY)
    suspend fun provideInviteKey(
        @Body request : InviteKeyRequest
    )

}