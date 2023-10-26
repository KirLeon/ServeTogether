package com.codingub.hackathonproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.codingub.hackathonproject.domain.use_cases.AddAnnouncementUseCase
import com.codingub.hackathonproject.domain.use_cases.DeleteAnnouncementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnnouncementInfoViewModel @Inject constructor(
    addAnnouncementUseCase: AddAnnouncementUseCase,
    deleteAnnouncementUseCase: DeleteAnnouncementUseCase
) : ViewModel(){
}