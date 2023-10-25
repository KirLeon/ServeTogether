package com.codingub.hackathonproject.network

/**
 * [AuthResult] provides HTTP responses from server:
 *
 *
 * [AuthResult.Authorized] -> User is authorized (code : 200)
 * [AuthResult.Unauthorized] -> User is unauthorized error (code : 401)
 * [AuthResult.BadRequest] -> Bad request error (code : 400)
 * [AuthResult.NotFound] -> Resource not found error (code : 404)
 *
 * UI
 * [AuthResult.Loading] -> UI class for progress bar and shimmer effect
 */
sealed class AuthResult<T>(val data: T? = null) {
    class Authorized<T>(data: T? = null): AuthResult<T>(data)
    class Unauthorized<T>: AuthResult<T>()
    class BadRequest<T>(val errorMessage: String) : AuthResult<T>()
    class NotFound<T>() : AuthResult<T>()
    class UnknownError<T>: AuthResult<T>()
    class Loading<T>(val state: Boolean = false): AuthResult<T>()
}
