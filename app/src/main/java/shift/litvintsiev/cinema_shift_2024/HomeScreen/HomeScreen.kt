package shift.litvintsiev.cinema_shift_2024.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import shift.litvintsiev.cinema_shift_2024.bottom_bar.CinemaBottomBar

@Composable
fun CinemaHomeScreen(modifier: Modifier) {
    Scaffold(
        bottomBar = { CinemaBottomBar() },
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CinemaMovieList(
                movies = listOf(
                    //Movie("Movie 1", "Description 1", "https://example.com/movie1.jpg"),
                    //Movie("Movie 2", "Description 2", "https://example.com/movie2.jpg"),
                    // Добавьте другие фильмы в список
                )
            )
        }
    }
}

@Composable
fun CinemaMovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            CinemaMovieCard(movie)
        }
    }
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


data class Movie(
    val title: String,
    val description: String,
    val imageUrl: String
)