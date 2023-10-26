package com.codingub.hackathonproject.ui.screens.announcements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.codingub.hackathonproject.R


@Composable
fun SearchBar() {
    //val viewModel:SearchBarViewModel = hiltViewModel()
    var message by remember {
        mutableStateOf("")
    }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(Color(0xFF1A182C))
        )

        TextField(
            value = message,
            onValueChange = { message = it },
            colors = TextFieldDefaults.colors(
                Color(0xFF9D8B66),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(1.4.dp)
                        .width(16.dp)
                        .height(16.dp)
                )
            },
            modifier = Modifier
                .padding(0.5.dp)
                .fillMaxWidth(0.9f)
                .height(54.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.search_bar))
            }
        )

    }

