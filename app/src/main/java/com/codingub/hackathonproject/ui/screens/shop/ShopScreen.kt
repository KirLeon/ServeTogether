package com.codingub.hackathonproject.ui.screens.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

val resourceNames = listOf(
    R.string.shop,
    R.string.cap,
    R.string.bag,
    R.string.mug,
    R.string.pen,
    R.string.thermal_mug,
    R.string.tshirt
)

@Composable
fun ShopScreen(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),
        verticalArrangement = Arrangement.Top,
       // horizontalAlignment = Alignment.Start
        ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp)
            .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = stringResource(id = R.string.shop),
                style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
            )
            )
            Row(
            ) {
                Text(text = "1800",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF)))
                Spacer(modifier = Modifier.width(10.dp))

            }
            Image(painter = painterResource(id = R.drawable.coin), contentDescription = "coin")
        }

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            repeat(resourceNames.size) {
                shopItem()
                Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            }
        }

    }
}