package com.example.splitapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.splitapp.presentation.addsplit.AddSplitViewModel

@Composable
fun CreateGroupScreen(modifier: Modifier = Modifier) {
    val viewModel: AddSplitViewModel = hiltViewModel()
    Column {
        Text("Create Group", color = Color.White)
    }
}