package com.example.mobiletechnicaltest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobiletechnicaltest.models.Laptop;
import com.example.mobiletechnicaltest.network.ApiClient;
import com.example.mobiletechnicaltest.network.ApiService;

public class LaptopDetailRepository {

    private ApiService apiService;

    public LaptopDetailRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<Laptop> getLaptopDetail(){
        MutableLiveData<Laptop> data = new MutableLiveData<>();
        return data;
    }
}
