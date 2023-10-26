package com.codingub.hackathonproject.network

/**
 * [EndPoints] stores endpoints for network calls
 */
object EndPoints {

    /*
        Auth
     */
    const val SIGNUP = "/api/v1/registration/user"
    const val SIGNIN = "/api/v1/authorize"
    const val AUTHENTICATE = "/.../"
    const val PROVIDE_INVITE_KEY = "/api/v1/registration/key"

    /*
        Announce
     */
    const val ANNOUNCEMENT = "/api/..."
    const val ADD_ANNOUNCEMENT = "/api/..."
    const val DELETE_ANNOUNCEMENT = "/api/..."

    /*
        Market
     */
    const val MARKET = "/api/..."
}