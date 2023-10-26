package com.codingub.hackathonproject.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.codingub.hackathonproject.data.remote.models.ExtAnnouncement
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



class SharedViewModel : ViewModel() {

    var inviteKey by mutableStateOf("")

    var anouncement by mutableStateOf(0)

}