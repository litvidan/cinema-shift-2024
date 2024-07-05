package shift.litvintsiev.cinema_shift_2024.bottom_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun CinemaBottomBar() {
    var selectedItemIndex by rememberSaveable{
        mutableStateOf(0)
    }

    NavigationBar(Modifier.fillMaxWidth()) {
        NavigationBarItem(
            selected = selectedItemIndex == 0,
            onClick = {selectedItemIndex = 0},
            icon = { Icon(Icons.Filled.Movie, contentDescription = "Афиша") },
            label = { Text(text = "Афиша") })

        NavigationBarItem(
            selected = selectedItemIndex == 1,
            onClick = {selectedItemIndex = 1},
            icon = { Icon(Icons.Filled.ConfirmationNumber, contentDescription = "Билеты") },
            label = { Text(text = "Билеты") })

        NavigationBarItem(
            selected = selectedItemIndex == 2,
            onClick = { selectedItemIndex = 2},
            icon = { Icon(Icons.Filled.Person, contentDescription = "Профиль") },
            label = { Text(text = "Профиль") })
    }
}