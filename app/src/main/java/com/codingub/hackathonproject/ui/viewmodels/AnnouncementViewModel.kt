package com.codingub.hackathonproject.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.domain.use_cases.AddAnnouncementUseCase
import com.codingub.hackathonproject.domain.use_cases.GetAllAnnouncementsUseCase
import com.codingub.hackathonproject.domain.use_cases.GetAnnouncementByIdUseCase
import com.codingub.hackathonproject.domain.use_cases.GetAnnouncementSearchUseCase
import com.codingub.hackathonproject.network.AuthResult
import com.codingub.hackathonproject.network.ServerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnnouncementViewModel @Inject constructor(
    private val getAllAnnouncementsUseCase: GetAllAnnouncementsUseCase,
    private val getAnnouncementByIdUseCase: GetAnnouncementByIdUseCase, //будет при выборе (коммуникация фрагментов)
    private val getAnnouncementSearchUseCase: GetAnnouncementSearchUseCase //!!!!!! добавить для searchBar
) : ViewModel() {

    var announcements: MutableState<List<Announcement>> = mutableStateOf<List<Announcement>>(
        emptyList()
    )

    private val _resultChannel = Channel<ServerResponse<List<Announcement>>>()
    val authResults = _resultChannel.receiveAsFlow()

    fun loadAnnouncements(){
        viewModelScope.launch {
            _resultChannel.send(ServerResponse.Loading(true))
            val result = getAllAnnouncementsUseCase()
            _resultChannel.send(result)
        }
    }

}