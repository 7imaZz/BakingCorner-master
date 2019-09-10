package com.example.bakingcorner.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakingcorner.API.CakeApi;
import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    List<CakeModel> cakes = new ArrayList<>();
    private CakesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.rv_cakes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        CakeApi cakeApi = retrofit.create(CakeApi.class);

        Call<List<CakeModel>> call = cakeApi.getCakes();

        call.enqueue(new Callback<List<CakeModel>>() {

            @Override
            public void onResponse(Call<List<CakeModel>> call, Response<List<CakeModel>> response) {

                cakes = response.body();

                adapter = new CakesAdapter(MainActivity.this, cakes);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CakeModel>> call, Throwable t) {

            }
        });
    }
}
