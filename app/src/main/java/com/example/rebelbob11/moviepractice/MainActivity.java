package com.example.rebelbob11.moviepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button button_simplified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        button_simplified = findViewById(R.id.simplified);

        button_simplified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent simplifyIntent = new Intent(getApplicationContext(),Prac2.class);
                startActivity(simplifyIntent);
            }
        });

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getPopularMovieList("447b7136e73421c643ab1cdf34b77c4c");

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                List<Movie> movies = response.body().getResults();

                String[] movieArray = new String[movies.size()];

                for (int i=0;i<movies.size();i++){
                    movieArray[i] = movies.get(i).getTitle();
                }

                for (Movie m:movies){
                    Log.d("Moviename"," " + m.getTitle());
                }

            listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,movieArray));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error"," "+t.getMessage());
                textView.setText(t.getMessage());

            }
        });
    }
}
