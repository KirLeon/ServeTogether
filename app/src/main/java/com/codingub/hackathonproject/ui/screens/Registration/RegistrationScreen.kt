package com.codingub.hackathonproject.ui.screens.Registration


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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.ui.validation.isPasswordValid
import com.codingub.hackathonproject.ui.viewmodels.RegistrationUiEvent
import androidx.hilt.navigation.compose.hiltViewModel
import com.codingub.hackathonproject.ui.screens.UpperScreen
import com.codingub.hackathonproject.ui.validation.isEqualPasswords
import com.codingub.hackathonproject.ui.validation.isPhoneValid
import com.codingub.hackathonproject.ui.viewmodels.RegistrationViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RegistrationScreen(
) {
    val viewModel = hiltViewModel<RegistrationViewModel>()
    var text_phone_number by rememberSaveable {
        mutableStateOf("+375")
    }

    var text_password by rememberSaveable {
        mutableStateOf("")
    }
    var text_confirm_password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            UpperScreen()
            Text(text = stringResource(id = R.string.registration))
            Spacer(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = text_phone_number,
                onValueChange = {
                    viewModel.onEvent(RegistrationUiEvent.SignUpPhoneNumberChanged(it))
                    if (it.startsWith("+375") || it.isEmpty()) {
                        text_phone_number = it
                    } else {
                        text_phone_number = "+375$it"
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                placeholder = {
                    Text(
                        text = stringResource(R.string.placeholder_phonenumber),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(327.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(10.dp)
                    )
            )

            Spacer(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = text_password,
                onValueChange = {
                    viewModel.onEvent(RegistrationUiEvent.SignUpPasswordChanged(it))
                    if (isPasswordValid(it)) {
                        text_password = it
                    }
                },
                supportingText = {
                    Text(text = stringResource(id = R.string.placeholder_check_password))
                },

                placeholder = {
                    Text(
                        text = stringResource(R.string.placeholder_password),
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                },
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


            Spacer(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = text_confirm_password,
                onValueChange = { text_confirm_password = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.placeholder_password),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                },
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

            Spacer(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    if (isPasswordValid(text_password) && isPhoneValid(text_phone_number) && isEqualPasswords(text_password, text_confirm_password)) {
                       viewModel.onEvent(RegistrationUiEvent.SignUp)
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
Text(text = "Регистрация")
            }
        }
    }
}