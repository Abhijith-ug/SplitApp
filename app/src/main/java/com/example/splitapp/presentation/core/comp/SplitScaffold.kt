package com.example.splitapp.presentation.core.comp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SplitScaffold(modifier: Modifier = Modifier,
                  topBar:@Composable () -> Unit = {},
                  floatingActionButton: @Composable () -> Unit = {},
                  floatingActionButtonPosition: FabPosition = FabPosition.End,
                  containerColor: Color = MaterialTheme.colorScheme.background,
                  content: @Composable () -> Unit,) {

    Scaffold(
        modifier = modifier,
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor
    ) { paddingValue ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValue)) {
            content.invoke()
        }
    }


}