package com.example.splitapp.presentation.addsplit

import com.example.splitapp.domain.ContactModel

data class AddSplitContentState(
    val searchQuery:String = "",
    val contacts:List<ContactModel>?=null,
    val isSearching:Boolean = false
)
