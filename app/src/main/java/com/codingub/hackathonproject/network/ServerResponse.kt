package com.codingub.hackathonproject.network

sealed class ServerResponse<T>(val data: T? = null){
    class Loading<T>(val state: Boolean = false) : ServerResponse<T>()

    class OK<T>(val content: T?) : ServerResponse<T>() //200
    class BadRequest<T>(val errorMessage: String) : ServerResponse<T>() //400
    class NotFound<T>() : ServerResponse<T>() //404
    class UnknownError<T>(val errorMessage: String? = null) : ServerResponse<T>() //other errors
    class Unauthorized<T>() : ServerResponse<T>()
   // class InternalServerError<T>() : ServerResponse<T>() //500
   // class Conflict<T>(val errorMessage: String) : ServerResponse<T>() //409
}
