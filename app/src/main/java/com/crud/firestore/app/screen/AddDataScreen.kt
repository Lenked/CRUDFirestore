package com.crud.firestore.app.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crud.firestore.app.Util.SharedViewModel
import com.crud.firestore.app.Util.UserData

@Composable
fun AddDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
){
    var userID by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var profession: String by remember { mutableStateOf("") }
    var age: String by remember { mutableStateOf("") }
    var ageInt: Int by remember { mutableStateOf(0) }

    val context = LocalContext.current

    // Main layout
    Column(modifier = Modifier.fillMaxSize()) {
        // Back button
        Row (
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
                ){
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back_button"
                )
            }
            // get data layout
            Column(
                modifier = Modifier
                    .padding(start = 60.dp, end = 60.dp, bottom = 60.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // UserID
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = userID,
                    onValueChange = {
                        userID = it
                    },
                    label = {
                        Text(text = "UserID")
                    }
                )
                // Name
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = {
                        Text(text = "Name")
                    }
                )
                // profession
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profession,
                    onValueChange = {
                        profession = it
                    },
                    label = {
                        Text(text = "Profession")
                    }
                )
                // age
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = age,
                    onValueChange = {
                        age = it
                        if (age.isNotEmpty()){
                            ageInt = age.toInt()
                        }
                    },
                    label = {
                        Text(text = "Age")
                    }
                )

                // Save Button
                Button(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth(),
                    onClick = {
                        val userData = UserData(
                            userID, name, profession, ageInt
                        )
                        
                        sharedViewModel.saveData(userData, context)
                    }
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}