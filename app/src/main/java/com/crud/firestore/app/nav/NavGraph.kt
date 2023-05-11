package com.crud.firestore.app.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crud.firestore.app.Util.SharedViewModel
import com.crud.firestore.app.screen.AddDataScreen
import com.crud.firestore.app.screen.GetDataScreen
import com.crud.firestore.app.screen.MainScreen

@Composable
fun NavGraph(
    navController: NavController,
    sharedViewModel: SharedViewModel
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.GetDataScreen.route
        ) {
            GetDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }
        composable(
            route = Screens.AddDataScreen.route
        ) {
            AddDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }
    }
}