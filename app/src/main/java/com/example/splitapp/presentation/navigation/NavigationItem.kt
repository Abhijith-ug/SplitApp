package com.example.splitapp.presentation.navigation

sealed class NavigationItem(val route:String) {
   data  object Home:NavigationItem("home")
    data object Split:NavigationItem("split")
   data object Contact:NavigationItem("contact")
    data object AddSplit:NavigationItem("add_split")

}