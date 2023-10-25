package com.codingub.hackathonproject.sdk

import androidx.annotation.StringRes
import com.codingub.hackathonproject.R

enum class UserRole(
   @StringRes private val type: Int
) {
    VOLUNTEER(R.string.volunteer),
    ADMIN(R.string.admin)
}