package com.example.moviebookingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.recycler_movie_info.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var movieList = mutableListOf(
            Movie("D&D", "e", "16+", "good one", "Brunao", "2hrs 21mins", "5", "0")
        )
        var nameView : TextView = findViewById(R.id.nameView)


        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = withContext(Dispatchers.IO) {
                    ApiClient.apiService.getMovies("https://imdb-api.com/en/API/InTheaters/k_qqtgw9kj")
                }
                Log.d("https://imdb-api.com/en/API/InTheaters/k_qqtgw9kj", "Response: $response")
                val movieList = response.items
                nameView.hint = movieList.firstOrNull()?.title ?: "No movie found"
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

//val adaptor = MovieAdaptor(movieList)
//        rvMovie.adapter = adaptor
//        rvMovie.layoutManager = LinearLayoutManager(this)