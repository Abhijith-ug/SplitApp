package com.example.splitapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {

    private val _event = Channel<HomeEvent>()
    val event = _event.receiveAsFlow()
    fun onEvent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.AddSplitClick -> {
                processEvent(HomeEvent.NavigateToContactList)
            }
        }
    }

    private fun processEvent(event: HomeEvent) {
         viewModelScope.launch {
            _event.send(event)
         }
    }
}