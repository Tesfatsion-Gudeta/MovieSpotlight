package com.example.moviespotlight;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.search.SearchBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchBar searchBar;
    static final String BASE_URL="https://api.themoviedb.org/3/";
    private static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
    private static final String LANGUAGE = "en-US";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.movieRecycler);
        searchBar=findViewById(R.id.movieSearch);
        ArrayList<MovieModel> movies=new ArrayList<>();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieInterface movieInterface=retrofit.create(MovieInterface.class);
        Call<List<MovieModel>> call=movieInterface.getMovies(API_KEY,LANGUAGE);
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
               if(response.isSuccessful()){
                   try {
                       JSONObject jsonObject = new JSONObject();
                       JSONArray results = jsonObject.getJSONArray("results");
                       List<MovieModel> movies=new ArrayList<>();

                       for (int i = 0; i < results.length(); i++) {
                           JSONObject movie = results.getJSONObject(i);

                           String title = movie.getString("title");
                           String posterPath = movie.getString("poster_path");
                           String releaseDate=movie.getString("release_date");
                           double voteAverage = movie.getDouble("vote_average");
                           String overview = movie.getString("overview");


                           MovieModel movieModel=new MovieModel(title,overview,posterPath,releaseDate,voteAverage);
                           movies.add(movieModel);


                       }
                       MovieAdapter adapter=new MovieAdapter(movies,MainActivity.this);
                       recyclerView.setAdapter(adapter);
                       recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }


               }else{
                   Toast.makeText(MainActivity.this, "service not working properly", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {

            }
        });






   }
}