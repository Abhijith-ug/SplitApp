package com.example.splitapp.presentation.home

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.splitapp.R
import com.example.splitapp.presentation.contact.ContactIntent
import com.example.splitapp.presentation.contact.ContactViewModel
import com.example.splitapp.presentation.core.CollectAsEvents
import com.example.splitapp.presentation.split_listing.comp.SplitItemComp

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               navigateToAddSplit:() -> Unit
                       ) {
    val context = LocalContext.current
    val viewModel: ContactViewModel = hiltViewModel()
    val homeViewModel:HomeViewModel = hiltViewModel()
    val viewState by viewModel.contactsState.collectAsStateWithLifecycle()

    CollectAsEvents(homeViewModel.event) {
        event ->
        when(event){
            HomeEvent.NavigateToContactList -> {
                 navigateToAddSplit.invoke()
            }
        }
    }


    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            if (permissions[Manifest.permission.READ_CONTACTS] == true ) {
             viewModel.onEvent(ContactIntent.LoadContacts)
            } else {
                AlertDialog.Builder(context)
                    .setTitle("permission required")
                    .setMessage("enable it in settings")
                    .setPositiveButton("go to settings") { _, _ ->
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }
                    .setNegativeButton("Cancel") { _, _ ->
                        Toast.makeText(context,
                            "Permission Required", Toast.LENGTH_SHORT).show()
                    }

                    .show()
            }
        }
    )
    LaunchedEffect(key1 = true) {
        checkContactPermission(context, permissionLauncher, uiIntent = {
            viewModel.onEvent(it)
        })
    }
    Box(
        modifier = modifier.

        fillMaxSize().
        background(Color.White).
                padding(vertical = 16.dp),
    ) {
        Column(

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "People", style = MaterialTheme.typography.titleLarge, color = Color.Black, fontWeight = FontWeight.Bold)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewState) {
                    SplitItemComp(item = it)
                }
            }
            Text(text = "Groups", style = MaterialTheme.typography.titleLarge, color = Color.Black, fontWeight = FontWeight.Bold)
            LazyVerticalGrid(columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(viewState) {
//                        SplitItemComp(item = it)
                    }
                })


        }
        Image(painter = painterResource(R.drawable.ic_add), contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.BottomEnd)
                .clickable {
                    homeViewModel.onEvent(HomeIntent.AddSplitClick)
                },)
    }

}

fun checkContactPermission(
    context: Context,
    permissionLauncher: ActivityResultLauncher<Array<String>>,
    uiIntent: (ContactIntent) -> Unit
) {
    when {
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED -> {




                uiIntent.invoke(ContactIntent.LoadContacts)



            //
            //            else {
//                uiIntent.invoke(DeliveryAddressMapIntent.SetDefaultLocation)
//                Toast.makeText(context, "location should be enabled", Toast.LENGTH_SHORT).show()
//            }


        }

        else -> {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.READ_CONTACTS
                )
            )
        }
    }
}