package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.network.AuthResult
import retrofit2.HttpException
import javax.inject.Inject

/**
 * [AuthRepository] is used for auth network calls
 */
interface AuthRepository {

    suspend fun signUp(request: RegisterDataRequest): AuthResult<Unit>
    suspend fun signIn(request: LoginDataRequest): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>

}

class AuthRepositoryImpl @Inject constructor(
    private val api: AppApi
) : AuthRepository{

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
            api.signIn(request)
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

