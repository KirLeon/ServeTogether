package com.codingub.hackathonproject.ui.screens.announcements

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingub.hackathonproject.R

@Composable
fun MySpacer(height: Dp = 10.dp) {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(height))
}
@Composable
fun AnnouncementsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.background(color = Color(0xFF1A182C))) {
        items(20) { //
            AnnouncementItem(
                title = "Hello",
                content = "ksadjhfkashdfjh h fkshfakjыфвпап выфdhf ahlsfs фывларо ро фылвдра рыдфлвра рм дфлвор",
                data = "21.12.2003",
                cost = 1800
            )
        }
    }


}

@Composable
fun AnnouncementItem(
    title: String,
    content: String,
    data: String,
    cost: Long
) {
    
    Card(
        modifier = Modifier
            .width(160.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .background(Color.White)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),


    ) {
        Column (

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_bold)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            )
            MySpacer(5.dp)
            Text(
                text = content,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                    fontWeight = FontWeight(400),
                    color = Color.Black
                    ),
                modifier = Modifier.padding(5.dp)

                )
            MySpacer()
            Row() {
                Text(
                    text = "$cost", style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                )
                Icon(painterResource(
                    id = R.drawable.coin),
                    contentDescription = null,
                    modifier = Modifier.padding(3.dp))
            }
            Text(text = data,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.monserrat_thin)),
                    fontWeight = FontWeight(600),
                    color = Color.Black
                )
            )
        }
    }
}


@Composable
fun AnnouncementScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar()
        MySpacer()
        AnnouncementsGrid()

    }
}