package com.example.splitapp.presentation.addsplit

import com.example.splitapp.domain.ContactModel

sealed class AddSplitContentIntent {
    data class SearchQueryChanged(val query:String):AddSplitContentIntent()
    data class OnContactItemClick(val item:ContactModel):AddSplitContentIntent()
    data class OnChipClose(val item:ContactModel):AddSplitContentIntent()
    data class CreateGroupClick(val item:ContactModel):AddSplitContentIntent()
}