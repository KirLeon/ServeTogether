package com.codingub.hackathonproject.domain.use_cases

import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.data.remote.requests.AddAnnouncementRequest
import com.codingub.hackathonproject.data.remote.responses.GetAllAnnouncementsResponse
import com.codingub.hackathonproject.data.remote.responses.GetAnnouncementResponse
import com.codingub.hackathonproject.data.repositories.AnnouncementRepository
import com.codingub.hackathonproject.network.ServerResponse
import javax.inject.Inject

class GetAnnouncementByIdUseCase @Inject constructor(private val repository: AnnouncementRepository) {

    suspend operator fun invoke(id: Long): ServerResponse<Announcement> {
        return repository.getAnnouncementById(id)
    }
}

class GetAllAnnouncementsUseCase @Inject constructor(private val repository: AnnouncementRepository) {

    suspend operator fun invoke(): ServerResponse<List<Announcement>> {
        return repository.getAllAnnouncements()
    }
}

class AddAnnouncementUseCase @Inject constructor(private val repository: AnnouncementRepository) {

    suspend operator fun invoke(request: AddAnnouncementRequest): ServerResponse<Unit> {
        return repository.addAnnouncement(request)
    }
}