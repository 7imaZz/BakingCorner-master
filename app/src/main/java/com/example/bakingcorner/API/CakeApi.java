package com.example.bakingcorner.API;

import com.example.bakingcorner.Model.CakeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CakeApi {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<CakeModel>> getCakes();

}
