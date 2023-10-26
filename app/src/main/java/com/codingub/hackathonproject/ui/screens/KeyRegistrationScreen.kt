package com.codingub.hackathonproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.network.ServerResponse
import com.codingub.hackathonproject.sdk.FragmentRoute
import com.codingub.hackathonproject.ui.viewmodels.InviteKeyEvent
import com.codingub.hackathonproject.ui.viewmodels.KeyRegistrationViewModel
import com.codingub.hackathonproject.ui.viewmodels.SharedViewModel


@Composable
fun KeyRegistrationScreen(
    navController: NavController
) {
    val sharedViewModel = SharedViewModel()
    val viewModel = hiltViewModel<KeyRegistrationViewModel>()

    var message by rememberSaveable {
        mutableStateOf("")
    }
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect() { result ->
            when (result) {
                is ServerResponse.OK -> {
                    navController.navigate(FragmentRoute.Register)
                }

                is ServerResponse.Unauthorized -> {
                    //возвращение к авторизации
                }

                is ServerResponse.BadRequest -> {
                    message = result.errorMessage
                }

                is ServerResponse.NotFound -> {
                    message = "Ошибка: Запрошенный ресурс не найден."
                }

                is ServerResponse.Loading -> {
                    //shimmer effect
                }

                is ServerResponse.UnknownError -> {
                    message = "Произошла неизвестная ошибка. Попробуйте позже."
                }

            }
        }
    }

    var inviteKey by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UpperScreen()

        Text(
            text = message,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 5.dp)
        )

        MyTextField(
            value = inviteKey,
            onValueChange = { inviteKey = it }
        )

        Text(
            text = stringResource(id = R.string.invite_key),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = (16 * 2).dp)
                .height(54.dp)
                .background(
                    color = Color(0xFF9D8B66),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .clickable {
                    viewModel.apply {
                        onEvent(InviteKeyEvent.InviteKeyChanged(inviteKey))
                        onEvent(InviteKeyEvent.ProvideInviteKey)
                    }
                }
                .wrapContentHeight()
        )

        MySpacer()

        Text(
            text = stringResource(R.string.login_screen_transition),
            Modifier.clickable {
                navController.navigate(FragmentRoute.Login)
            },
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                fontWeight = FontWeight(400),
                color = Color.White,
            )
        )
    }


    @Composable
    fun MyTextField(
        value: String,
        onValueChange: (String) -> Unit = {},
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        supportingText: @Composable (() -> Unit)? = null,
        visualTransformation: VisualTransformation = VisualTransformation.None,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            supportingText = supportingText,
            visualTransformation = visualTransformation,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(
                color = Color.White
            )
        )
        MySpacer()
    }


    @Composable
    fun MySpacer() {
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
        )
    }

}