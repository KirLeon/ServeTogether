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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingub.hackathonproject.ui.validation.isPasswordValid
import com.codingub.hackathonproject.ui.viewmodels.AuthorizationViewModel

@Composable
fun AuthorizationScreen(
   // viewModel: AuthorizationViewModel
) {


    var text_login by rememberSaveable {
        mutableStateOf("")
    }

    var text_password by rememberSaveable {
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

            OutlinedTextField(
                value = text_login,
                onValueChange = { text_login = it },
                placeholder = {},
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
                .height(18.dp)
                .fillMaxWidth())

            OutlinedTextField(
                value = text_password,
                onValueChange = {
                    if (isPasswordValid(it)) {
                        text_password = it
                    } },
                supportingText = {
                    Text(text = "Your password must be 6-20 characters long")
                },
                placeholder = {},
                modifier = Modifier
                    .height(60.dp)
                    .width(327.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(10.dp)
                    ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier
                .height(18.dp)
                .fillMaxWidth())

            Button(
                onClick = {
                    if (isPasswordValid(text_password)) {
                        // хороший пароль
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

            }
        }
    }


}

@Preview
@Composable
fun previewAuth(){
    AuthorizationScreen()
}