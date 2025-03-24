package com.example.splitapp.presentation.core.comp

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitapp.R
import com.example.splitapp.presentation.core.SplitTypography
import com.example.splitapp.ui.theme.fonts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplitSearchComponent(
    searchQuery:String,
    onQueryChanged:(String) -> Unit,
    modifier: Modifier = Modifier) {

    TextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        modifier = modifier
            .clip(
                MaterialTheme.shapes.medium
            )
            .indicatorLine(
                enabled = false,
                isError = false,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                focusedIndicatorLineThickness = 0.dp,
                unfocusedIndicatorLineThickness = 0.dp
            ),
        placeholder = { Text(text = stringResource(R.string.search), style = SplitTypography.SplitStyle400.copy(
            color = Color.Black,
            fontSize = 16.sp
        ))},
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = ""
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedContainerColor = Color.White,
            unfocusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
        )
    )

}