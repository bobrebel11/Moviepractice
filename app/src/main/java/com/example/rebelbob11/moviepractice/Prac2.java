package com.example.rebelbob11.moviepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Prac2 extends AppCompatActivity {

    ListView listView1;
    String[] heros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac2);

       listView1 = findViewById(R.id.listView1);

        ApiInterface apiInterface = ApiClient.getRetrofit1().create(ApiInterface.class);

        retrofit2.Call<List<Hero>> call = apiInterface.getHeros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                heros = new String[heroList.size()];
                for (int i=0;i<heroList.size();i++){
                    heros[i]=heroList.get(i).getName();
                    Log.d("SIMPLIFIED",heros[i]);

                }

                listView1.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,heros));



            }

            @Override
            public void onFailure(retrofit2.Call<List<Hero>> call, Throwable t) {

                Toast.makeText(Prac2.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
