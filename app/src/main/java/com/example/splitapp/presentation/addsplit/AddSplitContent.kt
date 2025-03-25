package com.example.splitapp.presentation.addsplit

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.splitapp.presentation.addsplit.comp.UserComponent
import com.example.splitapp.presentation.contact.ContactViewModel
import com.example.splitapp.presentation.core.comp.SplitSearchComponent

@Composable
fun AddSplitContent(modifier: Modifier = Modifier,viewState:AddSplitContentState,intent:(AddSplitContentIntent) -> Unit) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SplitSearchComponent(searchQuery = viewState.searchQuery, onQueryChanged = {
                  intent(AddSplitContentIntent.SearchQueryChanged(it))
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        Log.d("contactssss", "AddSplitContent: ${viewState.contacts}")
        viewState.contacts?.let {
            LazyColumn  {
               items(it){
                  UserComponent(item = it)
               }
            }
        }

    }
}