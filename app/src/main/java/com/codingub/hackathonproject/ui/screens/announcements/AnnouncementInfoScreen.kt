package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.ui.screens.groups.SpacerGroup


@Composable
fun AnnouncementInfoScreen (
    id: Long
) {
    //val viewModel = hiltViewModel<>()
    Column (
        verticalArrangement = Arrangement.Center
    ) {
    Text(
        text = "Авария в санузле",
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.monserrat_bold)),
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
        )
    )
        SpacerGroup(20.dp)
        Text(text = "На втором этаже в колледже поломался туалет просьба починить")
        SpacerGroup(10.dp)
        Row () {
           Text(text = "1800")
           Image(painter = painterResource(id = R.drawable.coin), contentDescription = "coin")
        }
        SpacerGroup(20.dp)
        Text(text = "Автор:${4}")
        SpacerGroup(10.dp)
        Text(text = "Дата:${4}")
        SpacerGroup(150.dp)

        CustomButtonInfo(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF549F57)),
            text = stringResource(id = R.string.confirm))

        SpacerGroup(10.dp)
        CustomButtonInfo(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF9F5454)),
            text = stringResource(id = R.string.refuse)
        )



    }
}
@Composable
fun CustomButtonInfo(
    onClick: () -> Unit,
    colors: ButtonColors,
    text: String
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF9F5454)
        )) {
        Text(text = stringResource(id = R.string.refuse))
    }
}