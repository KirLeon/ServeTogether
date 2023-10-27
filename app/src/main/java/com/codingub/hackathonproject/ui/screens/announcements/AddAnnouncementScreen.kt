package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.domain.use_cases.AddAnnouncementUseCase



@Composable
fun AddAnnouncementScreen() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var sum by remember { mutableStateOf(TextFieldValue("")) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextField(
                value = title,
                label = "Название",
                onValueChange = {  }
            )
            MyTextField(
                value = description,
                label = "Описание",
                onValueChange = {  }
            )
            MyTextField(
                value = sum,
                label = "Сумма",
                onValueChange = {  }
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .drawWithCache {
                        onDrawBehind {
                            val dash = 2.dp.toPx()
                            val stroke = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    intervals = floatArrayOf(dash, dash),
                                    phase = 0f
                                )
                            )
                            drawRoundRect(
                                color = Color.Black,
                                style = stroke,
                                cornerRadius = CornerRadius((64 / 2).dp.toPx())
                            )
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Загрузить изображение",
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = "Создать",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .padding(horizontal = 10.dp)
                    .background(
                        color = Color.Yellow,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .wrapContentHeight()
                    .clickable {
                        // тут обработка нажания на кнопку
                        // значения полей лежат в $title, $description и $sum в начале функции
                    }
            )
        }
    }
}

@Composable
fun MyTextField(
    value: TextFieldValue,
    label:String,
    onValueChange: (String) -> Unit
){/*
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label)}
        )
*/}