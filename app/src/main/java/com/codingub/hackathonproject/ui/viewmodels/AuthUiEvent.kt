package com.codingub.hackathonproject.ui.viewmodels

sealed class RegistrationUiEvent {

    data class SignUpUsernameChanged(val value: String) : RegistrationUiEvent()
    data class SignUpPasswordChanged(val value: String) : RegistrationUiEvent()
    data class SignUpPhoneNumberChanged(val value: String) : RegistrationUiEvent()
    data class UseInviteKey(val value: String) :  RegistrationUiEvent()
    object SignUp : RegistrationUiEvent()
}

sealed class LoginUiEvent {

    data class SignInUsernameChanged(val value: String): LoginUiEvent()
    data class SignInPasswordChanged(val value: String): LoginUiEvent()
    object SignIn: LoginUiEvent()
}

sealed class InviteKeyEvent {
    data class InviteKeyChanged(val value: String): InviteKeyEvent()
    object ProvideInviteKey: InviteKeyEvent()

}