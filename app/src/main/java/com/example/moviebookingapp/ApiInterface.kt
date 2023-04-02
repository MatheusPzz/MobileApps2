package com.example.moviebookingapp
import retrofit2.http.GET
import retrofit2.http.Query

class ApiInterface
{

    interface ApiService {
        @GET("https://imdb-api.com/en/API/InTheaters/k_qqtgw9kj")
        suspend fun getMovies(@Query("tt10366206") tt10366206: String): ApiResponse
    }
    data class ApiResponse(
        val items: List<Movie>
    )
}