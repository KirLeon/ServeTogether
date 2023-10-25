package com.codingub.hackathonproject.data.remote

import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.network.EndPoints.SIGNIN
import com.codingub.hackathonproject.network.EndPoints.SIGNUP
import retrofit2.http.Body
import retrofit2.http.POST

interface AppApi{

    @POST(SIGNUP)
    suspend fun signUp(
        @Body request : RegisterDataRequest
    )

    @POST(SIGNIN)
    suspend fun signIn(
        @Body request : LoginDataRequest
    )

}