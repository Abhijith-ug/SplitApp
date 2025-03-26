package com.example.splitapp.presentation.addsplit

import com.example.splitapp.domain.ContactModel

sealed class AddSplitEvent {
    data class NavigateToCreateGroup(val item:ContactModel):AddSplitEvent()
}