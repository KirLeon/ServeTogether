package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.domain.use_cases.AddAnnouncementUseCase


@Composable
fun AddAnnouncementScreen() {
    Column(){
        Card (

        ) {

        }
    }
    Text(
        text = stringResource(id = R.string.new_announcement),
        style = TextStyle(
        fontSize = 25.sp,
        fontFamily = FontFamily(Font(R.font.monserrat_bold)),
        fontWeight = FontWeight(600),
        color = Color(0xFFFFFFFF))
    )


}
