package com.codingub.hackathonproject.ui.screens.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codingub.hackathonproject.R

@Composable
fun SpacerGroup(
    height: Dp = 25.dp
) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    )
}

@Composable
fun GroupsScreen(
    navController: NavController
) {

    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        SpacerGroup(40.dp)
        Text(text = stringResource(id = R.string.groups),
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Left,
            )
        )
        SpacerGroup()
        ButtonGroup(text = stringResource(id = R.string.create_group))
        SpacerGroup()
        ButtonGroup(text = stringResource(id = R.string.join_to_group))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonGroup(
    text:String
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(44.dp),
       colors = ButtonDefaults.buttonColors(
           containerColor = Color.White
       ),
        onClick = {})

    {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                fontWeight = FontWeight(600),
                color = Color.Black
            )
        )
    }
}