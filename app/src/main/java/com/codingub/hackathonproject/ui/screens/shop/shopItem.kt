package com.codingub.hackathonproject.ui.screens.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingub.hackathonproject.R

@Composable
fun shopItem() {

    Box(modifier = Modifier
        .padding(1.dp)
        .width(344.dp)
        .height(77.dp)
        .background(color = Color(0xFFE4E4E4))

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),

        ) {
            Image(
                painter = painterResource(id = R.drawable.cap),
                contentDescription = null
            )
            Text(text = "Кепка")
        } }
    }

@Preview
@Composable
fun prev() {
    shopItem()
}