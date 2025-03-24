package com.example.splitapp.presentation.addsplit

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class AddSplitViewModel @Inject constructor():ViewModel() {


    private val _contentState = MutableStateFlow(AddSplitContentState())
    val contentState = _contentState.asStateFlow()

    fun onIntent(intent:AddSplitContentIntent){
        when(intent){
            is AddSplitContentIntent.SearchQueryChanged -> {
                queryChanged(query = intent.query)
            }
        }
    }

    private fun queryChanged(query:String){
        _contentState.update {
            it.copy(
                searchQuery = query
            )
        }
    }
}