package com.codingub.hackathonproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.ui.validation.isInviteKeyValid
import com.codingub.hackathonproject.ui.viewmodels.InviteKeyEvent
import com.codingub.hackathonproject.ui.viewmodels.KeyRegistrationViewModel
import com.codingub.hackathonproject.ui.viewmodels.SharedViewModel


@Composable
fun KeyRegistrationScreen() {
    val sharedViewModel = SharedViewModel()
    val keyRegistrationViewModel = hiltViewModel<KeyRegistrationViewModel>()

    var invite_key by rememberSaveable {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UpperScreen()
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            OutlinedTextField(
                value = invite_key,
                onValueChange = {
                    keyRegistrationViewModel.onEvent(InviteKeyEvent.InviteKeyChanged(it))
                    invite_key = it },
                placeholder = { Text(text = stringResource(R.string.placeholder_invite_key),
                    style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),

                    ))},
                modifier = Modifier
                    .height(60.dp)
                    .width(327.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))
            Button(
                onClick = {
                    if (isInviteKeyValid(invite_key) ) {
                        //sharedViewModel.inviteKey = invite_key
                        keyRegistrationViewModel.onEvent(InviteKeyEvent.ProvideInviteKey)

                    } else {
                        // плохой пароль
                    }
                },
                modifier = Modifier
                    .width(327.dp)
                    .height(54.dp)
                    .background(
                        color = Color(0xFF9D8B66),
                        shape = RoundedCornerShape(size = 10.dp)
                    )

            ) {
                Text(
                    text = "Ввести",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
            )

        }
    }

}