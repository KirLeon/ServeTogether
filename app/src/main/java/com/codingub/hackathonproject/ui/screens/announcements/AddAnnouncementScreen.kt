package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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


@Composable
fun AddAnnouncementScreen() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var sum by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MySpacer()

            Text(
                text = stringResource(id = R.string.create_new_announcement ),
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),),
                textAlign = TextAlign.Center
            )

        MySpacer(5.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyTextFieldAnnouncement(
                    value = title,
                    label = stringResource(id = R.string.name),
                    onValueChange = { }
                )
                MyTextFieldAnnouncement(
                    value = description,
                    label = stringResource(id = R.string.description),
                    onValueChange = { }
                )
                MyTextFieldAnnouncement(
                    value = sum,
                    label = stringResource(id = R.string.sum),
                    onValueChange = { }
                )
                MySpacer()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
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
                        stringResource(id = R.string.download_image),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),

                            textAlign = TextAlign.Center,
                        )
                    )
                }
                MySpacer(5.dp)
                createButton(stringResource(id = R.string.create))
            }
        }

        MySpacer(5.dp)
        Text(
            text = stringResource(id = R.string.created),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Left,
            )
        )
        MySpacer(5.dp)
        Card(
            modifier = Modifier.fillMaxWidth(0.95f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 1.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //stringRes не надо, данные из бд
                TextBoxCreated(text = "Title")
                drawLine()
                TextBoxCreated(text = "Description")
                drawLine()
                TextBoxCreated(text = "Cost")
                drawLine()
                MySpacer(5.dp)
                Box(modifier = Modifier
                    .width(219.dp)
                    .height(101.dp)){
                Image(
                    //размеры картинки указаны по фигме, нужно решить отптимальный размер для картинки
                    painter = painterResource(id = R.drawable.cap),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                )
                }
                MySpacer(5.dp)
                createButton(text = stringResource(id = R.string.create))
                MySpacer(5.dp)
                createButton(text = stringResource(id = R.string.download))

            }
        }


    }
}

@Composable
fun createButton(
    text:String
) {
    Text(
        text = text,
        color = Color.Black,
        style = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),

            textAlign = TextAlign.Center,
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .padding(horizontal = 10.dp)
            .background(
                color = Color(0xFF9D8B66),
                shape = RoundedCornerShape(16.dp)
            )
            .wrapContentHeight()
            .clickable {
                // тут обработка нажания на кнопку
                // значения полей лежат в $title, $description и $sum в начале функции
            }
    )
}
@Composable
fun MyTextFieldAnnouncement(
    value: TextFieldValue,
    label: String,
    onValueChange: (TextFieldValue) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            )
        },
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedLabelColor = Color.DarkGray,
            // focusedIndicatorColor = Color.DarkGray,
            unfocusedIndicatorColor = Color.Black
        ),
       // modifier = Modifier.height(50.dp)
        )
}

@Composable
fun drawLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 1.dp.toPx()
        )
    }
}
@Composable
fun TextBoxCreated(
    text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(16.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )

    }
}
