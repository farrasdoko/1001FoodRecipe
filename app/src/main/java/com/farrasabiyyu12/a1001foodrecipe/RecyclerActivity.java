package com.farrasabiyyu12.a1001foodrecipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.farrasabiyyu12.a1001foodrecipe.Adapter.CustomAdapter;
import com.farrasabiyyu12.a1001foodrecipe.Model.ResponseRecipe;
import com.farrasabiyyu12.a1001foodrecipe.Model.ResultsItem;
import com.farrasabiyyu12.a1001foodrecipe.Rest.ApiClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.rv_list_makanan)
    RecyclerView rvListMakanan;

    String i, q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
//        rvListMakanan = findViewById(R.id.rv_list_makanan);

        i = getIntent().getStringExtra("i");
        q = getIntent().getStringExtra("q");

        getData();
    }

    private void getData() {
        Call<ResponseRecipe> recipeCall = ApiClient.getInstance().getRecipe(i, q);
        recipeCall.enqueue(new Callback<ResponseRecipe>() {
            @Override
            public void onResponse(Call<ResponseRecipe> call, Response<ResponseRecipe> response) {
                Boolean status = true;
                if (status){
                    rvListMakanan.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                    List<ResultsItem> resultsItems = response.body().getResults();
                    Log.d("Retrofit Get", "Jumlah Data = " + String.valueOf(resultsItems.size()));
                    rvListMakanan.setAdapter(new CustomAdapter(resultsItems, RecyclerActivity.this));
                }
            }

            @Override
            public void onFailure(Call<ResponseRecipe> call, Throwable t) {
                Log.d("Retrofit Get", t.getMessage());
            }
        });
    }
}
