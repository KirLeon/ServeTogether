package com.codingub.hackathonproject.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.domain.use_cases.RegisterUseCase
import com.codingub.hackathonproject.network.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registration: RegisterUseCase
) : ViewModel(){

   var state by mutableStateOf(RegisterState())

    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()


    fun onEvent(event: RegistrationUiEvent) {
        when (event) {
            is RegistrationUiEvent.SignUpUsernameChanged -> {
                state = state.copy(signUpUsername = event.value)
            }

            is RegistrationUiEvent.SignUpPasswordChanged -> {
                state = state.copy(signUpPassword = event.value)
            }

            is RegistrationUiEvent.SignUpPhoneNumberChanged -> {
                state = state.copy(signUpPhoneNumber = event.value)

            }
            is RegistrationUiEvent.UseInviteKey -> {
                state = state.copy(inviteKey = event.value)
            }
            is RegistrationUiEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            resultChannel.send(AuthResult.Loading(true))
            val result = registration(
                RegisterDataRequest(
                    username = state.signUpUsername,
                    password = state.signUpPassword,
                    phoneNumber = state.signUpPhoneNumber,
                    inviteKey = state.inviteKey
                )
            )
            resultChannel.send(result)
        }
    }
}