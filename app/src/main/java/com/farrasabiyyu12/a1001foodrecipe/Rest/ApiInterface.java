package com.farrasabiyyu12.a1001foodrecipe.Rest;

import com.farrasabiyyu12.a1001foodrecipe.Model.ResponseRecipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api")
    Call<ResponseRecipe> getRecipe(
            @Query("i") String i,
            @Query("q") String q
    );
}
