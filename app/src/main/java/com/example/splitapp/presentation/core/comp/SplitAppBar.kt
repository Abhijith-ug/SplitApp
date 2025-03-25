package com.example.splitapp.presentation.core.comp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitapp.R
import com.example.splitapp.presentation.core.SplitTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplitAppBar(modifier: Modifier = Modifier,
                mainText:String,
                actionIcon: Painter?=null,
                iconClick:() -> Unit = {},
                back:() -> Unit = {} ) {

    TopAppBar(
        title ={
          Text(text = mainText, style = SplitTypography.SplitStyle600.copy(
              color = Color.Black,
              fontSize = 24.sp
          ))
        },
        navigationIcon = {
            IconButton(
                onClick ={
                    back.invoke()
                }
            ) {
                 Icon(painter = painterResource(R.drawable.ic_back_arrow),contentDescription = null)
            }
        },
        actions = {
            if (actionIcon != null) {
                IconButton(onClick = {
                    iconClick.invoke()
                }) {
                    Icon(
                        painter = actionIcon,
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = Modifier.shadow(elevation = 2.dp)
        )
    
}