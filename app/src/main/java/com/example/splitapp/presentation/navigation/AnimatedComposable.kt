package com.example.splitapp.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.horizontalSlideComposable(
    route: String,
    composable: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        enterTransition = {
            return@composable slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300),
            )
        },
        exitTransition = {
            return@composable slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(400),
                targetOffset = { it / 3 }
            )
        },
        popEnterTransition = {

            return@composable slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300),
                initialOffset = { it / 3 }
            )
        },
        popExitTransition = {
            return@composable slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(400)
            )
        }) { backStackEntry ->
        composable(backStackEntry)
    }
}