package com.example.splitapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.splitapp.presentation.navigation.SplitNavHost
import com.example.splitapp.ui.theme.SplitAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SetBarColors()
            SplitAppTheme {

                Scaffold {
                    innerPadding ->
                    val infiniteTransition = rememberInfiniteTransition()


                 SplitNavHost(navController = rememberNavController())


                }
            }
        }
//        checkContactsPermission()
    }
//    private fun checkContactsPermission() {
//        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS)
//            != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.READ_CONTACTS),
//                1
//            )
//        } else {
//            viewModel.fetchContacts() // If permission is already granted, fetch contacts
//        }
//    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        if (requestCode == 1) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                viewModel.fetchContacts() // Call ViewModel function to fetch contacts
//            } else {
//                Toast.makeText(this, "Permission denied to read contacts", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

}

@SuppressLint("ContextCastToActivity")
@Composable
private fun SetBarColors() {
    val statusBarLight = MaterialTheme.colorScheme.background.toArgb()
    val statusBarDark = MaterialTheme.colorScheme.background.toArgb()
    val navigationBarLight = MaterialTheme.colorScheme.primary.toArgb()
    val navigationBarDark = MaterialTheme.colorScheme.primary.toArgb()
    val isDarkMode = isSystemInDarkTheme()
    val context = LocalContext.current as ComponentActivity

    DisposableEffect(isDarkMode) {
        context.enableEdgeToEdge(
            statusBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    statusBarLight,
                    statusBarDark
                )
            } else {
                SystemBarStyle.dark(
                    statusBarDark
                )
            },
            navigationBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    navigationBarLight,
                    navigationBarDark
                )
            } else {
                SystemBarStyle.dark(navigationBarDark)
            }
        )

        onDispose { }
    }
}

