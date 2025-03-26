package com.example.splitapp.presentation.core.comp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitapp.presentation.core.SplitTypography
import com.example.splitapp.ui.theme.fonts

@Composable
fun StandardSplitButton(
    modifier: Modifier,
    buttonText:String,
    containerColor:Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    disabledContainerColor:Color = MaterialTheme.colorScheme.primaryContainer,
    disabledContentColor:Color = MaterialTheme.colorScheme.primary,
    textStyle:TextStyle = SplitTypography.SplitStyle600.copy(fontSize = 16.sp),
    iconTint: Color = White,
    @DrawableRes iconLeading: Int? = null,
    @DrawableRes iconTrailing: Int? = null,
    isEnable: Boolean = true,
    isLoading: Boolean = false,
    shapes: CornerBasedShape = MaterialTheme.shapes.small,
    border: BorderStroke?= null,
    onClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
//To show keyboard
    Button(enabled = isEnable,
        modifier = modifier,
        contentPadding = contentPadding,

        onClick = {
            if (!isLoading) {
                onClick.invoke()
                //To hide keyboard
                keyboardController?.hide()
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        ),
        shape = shapes,
        border = border,
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(28.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        iconLeading?.let {
                            Icon(
                                painterResource(id = it),
                                contentDescription = null,
                                modifier = Modifier.padding(horizontal = 6.dp),
                                tint = iconTint
                            )
                        }
                        Text(
                            text = buttonText,
                            modifier = Modifier,
                            style = textStyle.copy(color = if (isEnable) contentColor else disabledContentColor),
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis
                        )
                        iconTrailing?.let {
                            Icon(
                                painterResource(id = it),
                                contentDescription = null,
                                modifier = Modifier.padding(horizontal = 6.dp),
                                tint = iconTint
                            )
                        }
                    }
                }
            }
        })
}