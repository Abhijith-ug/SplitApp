package com.example.splitapp.presentation.addsplit

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.splitapp.R
import com.example.splitapp.presentation.addsplit.comp.UserChipItem
import com.example.splitapp.presentation.addsplit.comp.UserComponent
import com.example.splitapp.presentation.contact.ContactViewModel
import com.example.splitapp.presentation.core.comp.SplitSearchComponent
import com.example.splitapp.presentation.core.comp.StandardSplitButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddSplitContent(modifier: Modifier = Modifier,viewState:AddSplitContentState,intent:(AddSplitContentIntent) -> Unit) {


 Box(
     modifier = Modifier.padding(bottom = 16.dp)
 ) {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .background(MaterialTheme.colorScheme.background)
     ) {
         SplitSearchComponent(searchQuery = viewState.searchQuery, onQueryChanged = {
             intent(AddSplitContentIntent.SearchQueryChanged(it))
         }, modifier = Modifier
             .fillMaxWidth()
             .padding(16.dp))

         if (  viewState.selectedGroupMembers.isNotEmpty()){

             FlowRow(
                 horizontalArrangement = Arrangement.spacedBy(4.dp),
                 verticalArrangement = Arrangement.spacedBy(4.dp),
                 modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
             ) {
                 viewState.selectedGroupMembers.forEach {
                     UserChipItem(text = it.name, onClose = {
                         intent(AddSplitContentIntent.OnChipClose(it))
                     })
                 }
             }
         }
         viewState.contacts?.let {
             LazyColumn  {
                 items(it){
                     UserComponent(item = it, onItemClick = {
                         intent(AddSplitContentIntent.OnContactItemClick(it))
                     })
                 }
             }
         }

     }
     if (viewState.selectedGroupMembers.isNotEmpty()){
         StandardSplitButton(modifier = Modifier.
         padding(8.dp).
         height(48.dp).
         fillMaxWidth().
         align(Alignment.BottomCenter),
             buttonText = stringResource(R.string.create_group),
             onClick = {
                 intent(AddSplitContentIntent.CreateGroupClick(viewState.selectedGroupMembers.first()))
             }
         )
     }

 }

}