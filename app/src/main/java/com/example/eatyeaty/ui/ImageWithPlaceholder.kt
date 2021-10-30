package com.example.eatyeaty.ui

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun ImageWithPlaceholder(
    modifier: Modifier = Modifier,
    image: Bitmap?,
    placeholder: Painter,
) {
    if (image != null) {
        Image(
            modifier = modifier,
            bitmap = image.asImageBitmap(),
            contentDescription = "",
        )
    } else {
        Image(
            modifier = modifier,
            painter = placeholder,
            contentDescription = "",
        )
    }
}