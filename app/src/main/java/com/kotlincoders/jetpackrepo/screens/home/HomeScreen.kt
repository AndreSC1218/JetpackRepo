package com.kotlincoders.jetpackrepo.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlincoders.jetpackrepo.screens.cars.CarsScreen
import com.kotlincoders.jetpackrepo.screens.users.UsersScreen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onUser: () -> Unit,
    onCar: () -> Unit
) {
    var currentScreen by rememberSaveable { mutableStateOf("Users") }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val openDrawer: () -> Unit = {
        coroutineScope.launch {
            drawerState.open()
        }
    }

    val closeDrawer: () -> Unit = {
        coroutineScope.launch {
            drawerState.close()
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.padding(end = 30.dp)
            ) {
                NavigationDrawerItem(
                    label = { Text(text = "Users") },
                    selected = currentScreen == "Users",
                    onClick = {
                        currentScreen = "Users"
                        closeDrawer()
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Cars") },
                    selected = currentScreen == "Cars",
                    onClick = {
                        currentScreen = "Cars"
                        closeDrawer()
                    })
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "App Title") },
                    navigationIcon = {
                        IconButton(onClick = openDrawer) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = {
                // Contenido dinámico según la selección en el Drawer
                Box(modifier = Modifier.padding(it)) {
                    when (currentScreen) {
                        "Users" -> UsersScreen()
                        "Cars" -> CarsScreen()
                    }
                }
            }
        )
    }
}
