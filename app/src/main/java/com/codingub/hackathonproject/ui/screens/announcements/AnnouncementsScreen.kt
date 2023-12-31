package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codingub.hackathonproject.R
import com.codingub.hackathonproject.data.remote.models.Announcement
import com.codingub.hackathonproject.network.ServerResponse
import com.codingub.hackathonproject.sdk.FragmentRoute
import com.codingub.hackathonproject.ui.viewmodels.AnnouncementViewModel

@Composable
fun MySpacer(height: Dp = 10.dp) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    )
}

@Composable
fun AnnouncementsGrid(announcements: List<Announcement>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.background(color = Color(0xFF1A182C))
    ) {
        items(announcements) { announcement ->
            AnnouncementItem(
                title = announcement.title,
                content = announcement.content,
                data = announcement.expirationDate,
                cost = announcement.price
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
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {
        Column(

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
            Row {
                Text(
                    text = "$cost", style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monserrat_semibold)),
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                )
                Icon(
                    painterResource(
                        id = R.drawable.coin
                    ),
                    contentDescription = null,
                    modifier = Modifier.padding(3.dp)
                )
            }
            Text(
                text = data,
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
fun AnnouncementScreen(navController: NavController) {

    var message by rememberSaveable {
        mutableStateOf("")
    }
    val viewModel = hiltViewModel<AnnouncementViewModel>()

    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when (result) {
                is ServerResponse.OK -> {
                    viewModel.announcements.value = result.data!!
                }

                is ServerResponse.Unauthorized -> {
                    navController.navigate(FragmentRoute.Login)
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
    val announcements = viewModel.announcements.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A182C)),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SearchBar()
        MySpacer()
        AnnouncementsGrid(announcements)

    }
}