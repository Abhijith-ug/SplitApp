package com.example.splitapp.presentation.contact

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splitapp.data.repository.ContactRepository
import com.example.splitapp.domain.ContactModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: ContactRepository):ViewModel() {

    private val _contactsState = MutableStateFlow<List<ContactModel>>(emptyList())
    val contactsState: StateFlow<List<ContactModel>> = _contactsState.asStateFlow()

  private  fun fetchContacts() {
        viewModelScope.launch {
            repository.getContacts()
                .catch {
                    e -> Log.e("ContactSync", "Error fetching contacts", e)
                }
                .collect { contacts ->
                    Log.d("Conatacts", "fetchContacts: ${contacts.size}")
                    _contactsState.value = contacts
                }
        }
    }

    fun onEvent( intent: ContactIntent){
        when(intent){
            ContactIntent.LoadContacts -> {
                fetchContacts()
            }
        }
    }
}