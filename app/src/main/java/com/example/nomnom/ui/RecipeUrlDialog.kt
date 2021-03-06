package com.example.nomnom.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeUrlDialog(
    onDismissRequest: () -> Unit,
    onSuccess: (url: String) -> Unit
) {
    val (url, setUrl) = remember {
        mutableStateOf("")
    }
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { },
        text = {
            OutlinedTextField(
                value = url,
                onValueChange = setUrl,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Optional template URL") },
                singleLine = true,
            )
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSuccess(url) }
                ) {
                    Text("Create")
                }
            }
        },
    )
}