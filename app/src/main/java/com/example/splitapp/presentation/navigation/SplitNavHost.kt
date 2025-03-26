package com.example.splitapp.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.splitapp.presentation.CreateGroupScreen
import com.example.splitapp.presentation.addsplit.AddSplitScreen
import com.example.splitapp.presentation.home.HomeScreen

@Composable
fun SplitNavHost(
  modifier:Modifier= Modifier,
  navController:NavHostController,
  startDestination:String = NavigationItem.Home.route
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable(NavigationItem.Home.route) {
           HomeScreen(navigateToAddSplit = {
               navController.navigate(NavigationItem.AddSplit.route)
           })
        }

        composable(NavigationItem.AddSplit.route) {
           AddSplitScreen(navigateToCreateGroup = {
               text ->
               navController.navigate(
                NavigationItem.CreateGroup.withQueryParams(
                    "hii".toNavQueryValue(argKey = ARG_GROUP_MEMBERS)
                )
               )
           })
        }

        composable(NavigationItem.CreateGroup.route) {
            entry ->
            CreateGroupScreen()

        }

    }

}