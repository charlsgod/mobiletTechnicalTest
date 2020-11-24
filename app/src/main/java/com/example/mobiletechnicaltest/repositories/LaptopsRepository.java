package com.example.mobiletechnicaltest.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobiletechnicaltest.models.Laptop;
import com.example.mobiletechnicaltest.network.ApiClient;
import com.example.mobiletechnicaltest.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaptopsRepository {

    private ApiService apiService;

    public LaptopsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<List<Laptop>> getLaptops(){
        MutableLiveData<List<Laptop>> data = new MutableLiveData<>();
        apiService.getLaptops().enqueue(new Callback<List<Laptop>>() {
            @Override
            public void onResponse(@NonNull Call<List<Laptop>> call, @NonNull Response<List<Laptop>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Laptop>> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
