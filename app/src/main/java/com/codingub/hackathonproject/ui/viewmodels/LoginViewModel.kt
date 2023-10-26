package com.codingub.hackathonproject.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.domain.use_cases.LoginUseCase
import com.codingub.hackathonproject.network.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val login: LoginUseCase
) : ViewModel(){

    var state by mutableStateOf(LoginState())

    private val _resultChannel = Channel<AuthResult<Unit>>()
    val authResults = _resultChannel.receiveAsFlow()


    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.SignInUsernameChanged -> {
                state = state.copy(signInUsername = event.value)
            }
            is LoginUiEvent.SignInPasswordChanged -> {
                state = state.copy(signInPassword = event.value)
            }
            is LoginUiEvent.SignIn -> {
                signIn()
            }
        }
    }

    private fun signIn() {
        viewModelScope.launch {
            _resultChannel.send(AuthResult.Loading(true))
            val result = login(
                LoginDataRequest(
                    username = state.signInUsername,
                    password = state.signInPassword
                )
            )
            _resultChannel.send(result)
        }
    }
}