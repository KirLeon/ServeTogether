package com.codingub.hackathonproject.ui.viewmodels

data class RegisterState(
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signUpPhoneNumber: String = "",
)

data class LoginState(
    val signInUsername: String = "",
    val signInPassword: String = ""
)

data class InviteKeyState(
    val inviteKey: String = ""
)

