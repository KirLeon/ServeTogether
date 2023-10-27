package com.codingub.hackathonproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.codingub.hackathonproject.domain.use_cases.AddAnnouncementUseCase
import com.codingub.hackathonproject.domain.use_cases.DeleteAnnouncementUseCase
import com.codingub.hackathonproject.domain.use_cases.GetAnnouncementByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnnouncementInfoViewModel @Inject constructor(
    private val getAnnouncementByIdUseCase: GetAnnouncementByIdUseCase
) : ViewModel(){

    //когда данные из SharedVm получаются, то вызывается getAnnouncementById
    
}