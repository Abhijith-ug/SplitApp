package com.example.splitapp.presentation.addsplit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splitapp.data.repository.ContactRepository
import com.example.splitapp.domain.ContactModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddSplitViewModel @Inject constructor(private val repository: ContactRepository):ViewModel() {


    private val _contentState = MutableStateFlow(AddSplitContentState())
    val contentState = _contentState.asStateFlow()

    private var searchJob: Job? = null
    private var originalContactList: List<ContactModel> = listOf() // Kee

    fun onIntent(intent:AddSplitContentIntent){
        when(intent){
            is AddSplitContentIntent.SearchQueryChanged -> {
                queryChanged(query = intent.query)
            }
        }
    }

    init {
        fetchContacts()
    }

    private  fun fetchContacts() {
        viewModelScope.launch {
            repository.getContacts()
                .catch {
                        e -> Log.e("ContactSync", "Error fetching contacts", e)
                }
                .collect { contacts ->
                    Log.d("Conatacts", "fetchContacts: ${contacts.size}")
                   _contentState.update {
                       it.copy(
                           contacts = contacts
                       )
                   }
                    originalContactList = contacts
                }
        }
    }

    private fun queryChanged(query:String){
        _contentState.update {
            it.copy(
                searchQuery = query.trim()
            )
        }
        searchJob?.cancel()
        if (query.isBlank()) {
            _contentState.update {
                it.copy(
                    contacts = originalContactList,
                    isSearching = false
                )
            }
            return
        }
        searchJob = viewModelScope.launch {
            // Update UI to show loading state
            _contentState.update {
                it.copy(isSearching = true)
            }

            // Perform search with debounce
            delay(300) // Add a small delay to reduce unnecessary searches

            val filteredItems = getFilteredContacts(query.trim())

            _contentState.update {
                it.copy(
                    contacts = filteredItems,
                )
            }
        }

    }
    private  fun getFilteredContacts(query: String): List<ContactModel> {
        // Prevent unnecessary filtering if query is too short
        if (query.isEmpty()) {
            return originalContactList
        }

        // More robust filtering with multiple search strategies
        return originalContactList.filter { contact ->
            contact.name.contains(query, ignoreCase = true)
        }
    }
}