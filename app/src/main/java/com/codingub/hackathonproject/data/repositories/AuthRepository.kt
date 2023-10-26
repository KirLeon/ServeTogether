package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.local.UserConfig
import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.data.remote.requests.InviteKeyRequest
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.network.AuthResult
import com.codingub.hackathonproject.network.ServerResponse
import com.codingub.hackathonproject.sdk.UserRole
import retrofit2.HttpException
import javax.inject.Inject

/**
 * [AuthRepository] is used for auth network calls
 */
interface AuthRepository {

    suspend fun provideInviteKey(request: InviteKeyRequest) : ServerResponse<UserRole>
    suspend fun signUp(request: RegisterDataRequest): AuthResult<Unit>
    suspend fun signIn(request: LoginDataRequest): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>

}

class AuthRepositoryImpl @Inject constructor(
    private val api: AppApi
) : AuthRepository{

    override suspend fun provideInviteKey(request: InviteKeyRequest) : ServerResponse<UserRole> {
        return try {
            val role = api.provideInviteKey(request).role
            ServerResponse.OK(UserRole.valueOf(role))
        } catch (e: HttpException){
           if (e.code() == 400) {
                ServerResponse.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404){
                ServerResponse.NotFound()
            } else {
                ServerResponse.UnknownError()
            }
        } catch (e: Exception){
            ServerResponse.UnknownError()
        }
    }

    override suspend fun signUp(request: RegisterDataRequest): AuthResult<Unit> {
        return try {
            api.signUp(request)
            signIn(LoginDataRequest(
                username = request.username,
                password = request.password
            ))
        } catch (e: HttpException){
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else if (e.code() == 400) {
                AuthResult.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404){
                AuthResult.NotFound()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(request: LoginDataRequest): AuthResult<Unit> {
        return try {
            val response = api.signIn(request)

            UserConfig.apply {
                setToken(response.authToken)
                setUsername(response.username)
                setPhoneNumber(response.phoneNumber)
                setCoins(response.coins)
            }

            AuthResult.Authorized()
        } catch (e: HttpException){
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else if (e.code() == 400) {
                AuthResult.BadRequest(e.response()?.errorBody()?.string() ?: "Unknown error")
            } else if (e.code() == 404){
                AuthResult.NotFound()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return AuthResult.Unauthorized()
    }
}

