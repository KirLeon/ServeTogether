package com.codingub.hackathonproject.network

/**
 * [EndPoints] stores endpoints for network calls
 */
object EndPoints {

    /*
        Auth
     */
    const val SIGNUP = "/api/v1/registration/user"
    const val PROVIDE_INVITE_KEY = "/api/v1/registration/key"


    const val SIGNIN = "/api/v1/authorize"
    const val AUTHENTICATE = "/api/v1/authorize"

    /*
        Announce
     */
    const val ANNOUNCEMENT = "/api/v1/admin/announcement"
    const val ALL_ANNOUNCEMENTS = "/api/v1/admin/announcement/all"

    /*
        Market
     */
    const val MARKET = "/api/..."
}