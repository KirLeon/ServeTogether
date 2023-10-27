package com.codingub.hackathonproject.sdk

import androidx.annotation.StringRes
import com.codingub.hackathonproject.R

enum class AnnouncementStatus(
    @StringRes private val status: Int
) {

    AVAILABLE(R.string.status_available),
    PENDING(R.string.status_pending),
    FINISHED(R.string.status_finished),
    IN_PROGRESS(R.string.status_in_progress)
}