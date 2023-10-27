package com.codingub.hackathonproject.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

object DateUtil {

    fun dateToString(value: Date): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val outputFormat = SimpleDateFormat("dd.MM.yy")

        return try {
            val parsedDate = inputFormat.parse(value.toString())
            outputFormat.format(parsedDate!!)
        } catch (e: Exception) {
            ""
        }
    }

}