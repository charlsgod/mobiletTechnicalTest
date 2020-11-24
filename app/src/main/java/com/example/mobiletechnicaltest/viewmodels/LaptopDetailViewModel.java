package com.example.mobiletechnicaltest.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobiletechnicaltest.models.Laptop;
import com.example.mobiletechnicaltest.repositories.LaptopDetailRepository;
import com.example.mobiletechnicaltest.repositories.LaptopsRepository;

import java.util.List;

public class LaptopDetailViewModel extends ViewModel {

    private LaptopDetailRepository laptopDetailRepository;

    public LaptopDetailViewModel(){
        laptopDetailRepository = new LaptopDetailRepository();
    }

    public LiveData<Laptop> getLaptopDetail() {
        return laptopDetailRepository.getLaptopDetail();
    }
}
