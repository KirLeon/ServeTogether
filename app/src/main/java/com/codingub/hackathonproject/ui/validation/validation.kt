package com.codingub.hackathonproject.ui.validation


fun isPasswordValid(password: String): Boolean {
    return password.length <= 20
}


