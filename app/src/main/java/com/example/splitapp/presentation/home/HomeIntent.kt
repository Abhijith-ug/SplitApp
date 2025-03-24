package com.example.splitapp.presentation.home

sealed class HomeIntent {
    data object AddSplitClick:HomeIntent()
}