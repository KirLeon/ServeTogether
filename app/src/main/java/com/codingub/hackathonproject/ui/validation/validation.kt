package com.codingub.hackathonproject.ui.validation


fun isPasswordValid(password: String): Boolean {
    return password.length <= 8
}

fun isEqualPasswords(first: String, second: String) : Boolean {
    return first == second
}

fun isPhoneValid(phone: String): Boolean {
    return phone.startsWith("+375") && phone.length == 13
}

fun isInviteKeyValid(key: String): Boolean {
    return key.length <= 20
}
