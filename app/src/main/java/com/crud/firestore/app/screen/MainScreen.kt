package com.crud.firestore.app.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crud.firestore.app.Util.SharedViewModel
import com.crud.firestore.app.nav.Screens

@Composable
fun MainScreen(
    navController: NavController
){
    Column(modifier = Modifier
        .padding(start = 50.dp, end = 50.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Get user data button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { 
                navController.navigate(Screens.GetDataScreen.route)
            }
        ) {
            Text(text = "Get User Data")
        }

        // Add user data button
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(Screens.AddDataScreen.route)
            }
        ) {
            Text(text = "Add User Data")
        }
    }
}