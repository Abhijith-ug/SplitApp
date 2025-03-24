package com.example.splitapp.presentation.addsplit

sealed class AddSplitContentIntent {
    data class SearchQueryChanged(val query:String):AddSplitContentIntent()
}