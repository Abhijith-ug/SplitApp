package com.example.splitapp.presentation.contact

sealed class ContactIntent {
    data object LoadContacts: ContactIntent()
}