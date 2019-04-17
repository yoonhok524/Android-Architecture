package com.youknow.movie.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youknow.movie.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreHolder> {

    private List<String> genres;

    public GenreAdapter(List<String> genres) {
        this.genres = genres;
    }

    @NonNull
    @Override
    public GenreHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new GenreHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_genre, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenreHolder holder, int position) {
        holder.tvGenre.setText(genres.get(position));
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    class GenreHolder extends RecyclerView.ViewHolder {

        TextView tvGenre;

        GenreHolder(@NonNull View itemView) {
            super(itemView);

            tvGenre = itemView.findViewById(R.id.tvGenre);
        }

    }
}
