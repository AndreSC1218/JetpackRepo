package com.kotlincoders.jetpackrepo.screens.users

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsersScreen(

) {
    // Lista de usuarios
    val users = listOf("User 1", "User 2", "User 3") // Tu lista de usuarios

    LazyColumn() {
        items(users) {
            UserListItem(user = it)
        }
    }
}

@Composable
fun UserListItem(user: String) {
    // Elemento de la lista de usuarios
    Text(
        text = user,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}