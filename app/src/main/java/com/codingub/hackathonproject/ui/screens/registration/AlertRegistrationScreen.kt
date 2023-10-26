package com.codingub.hackathonproject.ui.screens.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class AlertDialogProperties(
    val size: DpConstraints = DpConstraints(),
)

data class DpConstraints(
    val maxWidth: Dp = Dp.Infinity,
    val maxHeight: Dp = Dp.Infinity,
)

data class DialogSize(
    val maxWidth: Dp = Dp.Infinity,
    val maxHeight: Dp = Dp.Infinity
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val showDialog = remember { mutableStateOf(false) }
    val showProgressBar = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                showDialog.value = true
                showProgressBar.value = true
                CoroutineScope(Dispatchers.Main).launch {
                    delay(1500)
                    showDialog.value = false
                    showProgressBar.value = false
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Show Dialog")
        }

        if (showDialog.value) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                showAlertDialog(
                    showProgressBar = showProgressBar.value,
                    onPositiveButtonClick = {
                        showDialog.value = false
                        showProgressBar.value = false
                    },
                )
            }
        }
    }
}

@Composable
fun showAlertDialog(
    showProgressBar: Boolean,
    onPositiveButtonClick: () -> Unit
) {
    val alertDialogProperties = remember { mutableStateOf(AlertDialogProperties()) }
    alertDialogProperties.value = alertDialogProperties.value.copy(
            size = DpConstraints(
                maxWidth = 30.dp,
                maxHeight = 30.dp,
            )
            )
    val dialogProperties = alertDialogProperties.value.toDialogProperties()
    AlertDialog(
        properties = dialogProperties,
        onDismissRequest = { },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(16.dp)
            ) {
                if (showProgressBar) {
                    CircularProgressIndicator(
                        modifier = Modifier.wrapContentSize(Alignment.Center)
                    )
                }
            }
        },
        confirmButton = {}
    )
}

fun AlertDialogProperties.toDialogProperties(): DialogProperties {
    return DialogProperties(
       /* size = DialogSize(
            maxWidth = size.maxWidth,
            maxHeight = size.maxHeight
        )*/
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting("Android")

}


