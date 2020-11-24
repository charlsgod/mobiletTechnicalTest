package com.example.mobiletechnicaltest.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobiletechnicaltest.models.Laptop;
import com.example.mobiletechnicaltest.repositories.LaptopsRepository;

import java.util.List;

public class LaptopsViewModel extends ViewModel {

    private LaptopsRepository laptopsRepository;

    public LaptopsViewModel(){
        laptopsRepository = new LaptopsRepository();
    }

    public LiveData<List<Laptop>> getLaptops() {
        return laptopsRepository.getLaptops();
    }
}
