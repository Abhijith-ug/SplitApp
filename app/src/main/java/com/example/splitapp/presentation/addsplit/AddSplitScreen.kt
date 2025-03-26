package com.example.splitapp.presentation.addsplit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.splitapp.domain.ContactModel
import com.example.splitapp.presentation.core.CollectAsEvents
import com.example.splitapp.presentation.core.comp.SplitAppBar
import com.example.splitapp.presentation.core.comp.SplitScaffold

@Composable
fun AddSplitScreen(modifier: Modifier = Modifier,
                   navigateToCreateGroup:(ContactModel)->Unit) {

    val viewModel:AddSplitViewModel = hiltViewModel()

    val viewState by viewModel.contentState.collectAsStateWithLifecycle()
    CollectAsEvents(viewModel.event) {
        event->
        when(event){
            is AddSplitEvent.NavigateToCreateGroup -> {
                navigateToCreateGroup(event.item)
            }
        }
    }

   SplitScaffold(
       topBar ={
          SplitAppBar(mainText = "Add Split")
       }
   ) {

       AddSplitContent(viewState = viewState, intent = viewModel::onIntent)

   }

}