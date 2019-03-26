package com.youknow.movie.ui.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youknow.domain.model.SimpleMovie;
import com.youknow.movie.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private Context context;
    private List<SimpleMovie> movies = new ArrayList<>();

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MovieHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int i) {
        SimpleMovie movie = movies.get(i);

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}").into(holder.ivPoster);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvReleaseDate.setText(movie.getReleaseDate());
        holder.tvRatingAvg.setText(String.valueOf(movie.getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<SimpleMovie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        public ImageView ivPoster;
        public TextView tvTitle;
        public TextView tvReleaseDate;
        public TextView tvRatingAvg;

        public MovieHolder(View itemView) {
            super(itemView);

            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvRatingAvg = itemView.findViewById(R.id.tvRatingAvg);

        }
    }
}
