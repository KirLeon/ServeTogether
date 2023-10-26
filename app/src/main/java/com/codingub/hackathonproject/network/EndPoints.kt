package com.codingub.hackathonproject.network

/**
 * [EndPoints] stores endpoints for network calls
 */
object EndPoints {

    /*
        Auth
     */
    const val SIGNUP = "/api/v1/signup/user"
    const val PROVIDE_INVITE_KEY = "/api/v1/signup/key"

    const val SIGNIN = "/api/v1/authorize"

    const val AUTHENTICATE = "/api/v1/auth"

    /*
        Announce
     */
    const val ANNOUNCEMENT = "/api/v1/announcement"
    const val ALL_ANNOUNCEMENTS = "/api/v1/announcement/all"
    const val TITLE_ANNOUNCEMENT = "/api/v1/announcement/title"

    /*
        Market
     */
    const val MARKET = "/api/..."

    /*
        Group
     */
    const val GROUPS = "/api/v1/groups"
    const val JOIN_GROUPS = "/api/v1/groups/join"
    const val LEAVE_GROUPS = "/api/v1/groups/leave"
}