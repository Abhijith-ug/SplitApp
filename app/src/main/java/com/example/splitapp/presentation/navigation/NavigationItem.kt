package com.example.splitapp.presentation.navigation

sealed class NavigationItem(val route:String,val routeId:String) {
   data  object Home:NavigationItem("home", routeId = "home")
    data object Split:NavigationItem("split", routeId = "split")
   data object Contact:NavigationItem("contact", routeId = "contact")
    data object AddSplit:NavigationItem("add_split", routeId = "add_split")

    data object CreateGroup :NavigationItem("create_group?".plus(
        navQuery(ARG_GROUP_MEMBERS)
    ),routeId = "create_group")

    fun withQueryParams(vararg params: String?): String {
        return buildString {
            append(routeId).append("?")
            params.forEach { arg ->
                append(",$arg")
            }
        }.replaceFirst(",", "", true)
    }
}