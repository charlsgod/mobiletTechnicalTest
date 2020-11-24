package com.example.mobiletechnicaltest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mobiletechnicaltest.R;
import com.example.mobiletechnicaltest.databinding.ActivityLaptopDetailBinding;
import com.example.mobiletechnicaltest.viewmodels.LaptopDetailViewModel;
import com.example.mobiletechnicaltest.viewmodels.LaptopsViewModel;

public class LaptopDetailActivity extends AppCompatActivity {

    private ActivityLaptopDetailBinding activityLaptopDetailBinding;
    private LaptopDetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLaptopDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_laptop_detail);
        doInitialization();
    }

    private void doInitialization(){
        viewModel = new ViewModelProvider(this).get(LaptopDetailViewModel.class);
        activityLaptopDetailBinding.btnBack.setOnClickListener(v -> onBackPressed());
        bindLaptopDetail();
    }

    private void bindLaptopDetail(){
        String laptopTitle = getIntent().getStringExtra("title");
        activityLaptopDetailBinding.setTitle(laptopTitle);

        String laptopDescription = getIntent().getStringExtra("description");
        activityLaptopDetailBinding.setDescription(laptopDescription);

        String laptopImage = getIntent().getStringExtra("image");
        activityLaptopDetailBinding.setImage(laptopImage);
    }


}