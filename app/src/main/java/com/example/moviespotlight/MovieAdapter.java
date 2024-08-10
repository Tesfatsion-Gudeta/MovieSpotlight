package com.example.moviespotlight;

import static com.example.moviespotlight.MainActivity.BASE_URL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<MovieModel> movies=new ArrayList<>();
    Context context;

    public MovieAdapter(List<MovieModel> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.movie_cardview,parent,false);

        MovieViewHolder holder=new MovieViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.title.setText(movies.get(position).getTitle());
        if (movies.get(position).getVote_average() != null) {
            holder.rating.setText("Rating: "+movies.get(position).getVote_average().toString());
        } else {
            holder.rating.setText("N/A");
        }

        String posterUrl="https://image.tmdb.org/t/p/w500"+movies.get(position).getPosterPath();
        Glide.with(context).asBitmap().load(posterUrl).into(holder.posterImage);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView cardView;
        private ImageView posterImage;
        private TextView title,rating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardview1);
            title=itemView.findViewById(R.id.movieTitle);
            rating=itemView.findViewById(R.id.rating1);
            posterImage=itemView.findViewById(R.id.moviePoster);
        }
    }
}
