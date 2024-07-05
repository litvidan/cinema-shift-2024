package shift.litvintsiev.cinema_shift_2024

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun CinemaHomeScreen() {
    Scaffold(
        bottomBar = { CinemaBottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CinemaMovieList(
                movies = listOf(
                    Movie("Movie 1", "Description 1", "https://example.com/movie1.jpg"),
                    Movie("Movie 2", "Description 2", "https://example.com/movie2.jpg"),
                    // Добавьте другие фильмы в список
                )
            )
        }
    }
}

@Composable
fun CinemaMovieList(movies: List<Movie>) {
    //LazyColumn {
      //  items(movies) { movie ->
        //    CinemaMovieCard(movie)
        //}
    //}
}

@Composable
fun CinemaMovieCard(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Отображение изображения фильма
        AsyncImage(
            model = movie.imageUrl,
            contentDescription = movie.title,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(movie.title, style = TextStyle(fontWeight = FontWeight.Bold))
            Text(movie.description)
        }
    }
}

@Composable
fun CinemaBottomBar() {
    BottomNavigation {
        BottomNavigationItem(
            selected = true,
            onClick = { /* Обработка нажатия на "Афишу" */ },
            icon = { Icon(Icons.Filled.Movie, contentDescription = "Афиша") },
            label = { Text("Афиша") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /* Обработка нажатия на "Билеты" */ },
            icon = { Icon(Icons.Filled.ConfirmationNumber, contentDescription = "Билеты") },
            label = { Text("Билеты") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /* Обработка нажатия на "Профиль" */ },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Профиль") },
            label = { Text("Профиль") }
        )
    }
}

data class Movie(
    val title: String,
    val description: String,
    val imageUrl: String
)