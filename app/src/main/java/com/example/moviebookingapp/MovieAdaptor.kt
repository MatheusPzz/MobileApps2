package com.example.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_movie_info.view.*

class MovieAdaptor(
    var movies: List<Movie>
) : RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_movie_info, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = movies[position].title
            tvStarring.text = movies[position].starring
            tvRunningTime.text = movies[position].running_time_mins.toString()
            tvSeatsRemaining.text = movies[position].seats_remaining.toString()

        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}