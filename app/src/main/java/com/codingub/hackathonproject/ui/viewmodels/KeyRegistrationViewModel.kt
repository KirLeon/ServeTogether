package com.codingub.hackathonproject.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingub.hackathonproject.data.remote.requests.InviteKeyRequest
import com.codingub.hackathonproject.domain.use_cases.ProvideInviteKeyUseCase
import com.codingub.hackathonproject.network.ServerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class KeyRegistrationViewModel @Inject constructor(
    private val provideInviteKey : ProvideInviteKeyUseCase
) : ViewModel() {

    var state by mutableStateOf(InviteKeyState())

    private val _resultChannel = Channel<ServerResponse<Unit>>()
    val authResults = _resultChannel.receiveAsFlow()


    fun onEvent(event: InviteKeyEvent) {
        when (event) {
            is InviteKeyEvent.InviteKeyChanged -> {
                state = state.copy(inviteKey = event.value)
            }
            is InviteKeyEvent.ProvideInviteKey -> {
                provideInviteKey()
            }
        }
    }

    private fun provideInviteKey() {
        viewModelScope.launch {
            _resultChannel.send(ServerResponse.Loading(true))
            val result = provideInviteKey(
                InviteKeyRequest(
                    inviteKey = state.inviteKey
                )
            )
            _resultChannel.send(result)
        }
    }
}