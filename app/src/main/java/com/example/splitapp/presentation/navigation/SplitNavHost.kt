package com.example.splitapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

        horizontalSlideComposable(NavigationItem.AddSplit.route) {
           AddSplitScreen()
        }

    }

}