package com.example.mobiletechnicaltest.network;

import com.example.mobiletechnicaltest.models.Laptop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("list")
    Call<List<Laptop>> getLaptops();

}
