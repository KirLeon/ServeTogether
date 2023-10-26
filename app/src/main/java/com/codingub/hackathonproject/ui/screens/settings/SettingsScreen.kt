package com.codingub.hackathonproject.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.ui.screens.groups.SpacerGroup


@Composable
fun SettingsScreen(
    navController: NavController,
    login: String,
    phoneNumber: String,
    feedback: String,
    starNumber: Int
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        SpacerGroup(20.dp)
        Text(
            text = stringResource(id = R.string.settings),
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
            )
        )
        SpacerGroup(20.dp)
        Text(
            text = stringResource(id = R.string.settings),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
            )
        )
        SpacerGroup(20.dp)

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(113.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = "Логин:${login}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF070707),
                )
            )
            SpacerGroup(5.dp)
            Text(
                text = "Телефон:${phoneNumber}",
            )
        }

        SpacerGroup(30.dp)
        Text(text = stringResource(id = R.string.feedback))
        SpacerGroup(20.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(113.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = feedback,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )

        }
        Row {
            repeat(starNumber) {
                Image(painter = painterResource(id = R.drawable.star), contentDescription = "star")
            }
        }
    }
}



