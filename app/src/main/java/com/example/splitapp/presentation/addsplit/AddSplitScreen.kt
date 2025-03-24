package com.example.splitapp.presentation.addsplit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.splitapp.presentation.core.comp.SplitAppBar
import com.example.splitapp.presentation.core.comp.SplitScaffold

@Composable
fun AddSplitScreen(modifier: Modifier = Modifier) {

    val viewModel:AddSplitViewModel = hiltViewModel()

    val viewState by viewModel.contentState.collectAsStateWithLifecycle()
   SplitScaffold(
       topBar ={
          SplitAppBar(mainText = "Add Split")
       }
   ) {

       AddSplitContent(viewState = viewState, intent = viewModel::onIntent)

   }

}