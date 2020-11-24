package com.example.mobiletechnicaltest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.mobiletechnicaltest.R;
import com.example.mobiletechnicaltest.adapters.LaptopsAdapter;
import com.example.mobiletechnicaltest.databinding.ActivityMainBinding;
import com.example.mobiletechnicaltest.listeners.LaptopListener;
import com.example.mobiletechnicaltest.models.Laptop;
import com.example.mobiletechnicaltest.viewmodels.LaptopsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LaptopListener {

    private ActivityMainBinding activityMainBinding;
    private LaptopsViewModel viewModel;
    private List<Laptop> laptops = new ArrayList<>();
    private LaptopsAdapter laptopsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLaptops();
    }

    private void doInitialization() {
        activityMainBinding.laptopsRecyclerview.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(LaptopsViewModel.class);
        laptopsAdapter = new LaptopsAdapter(laptops, this);
        activityMainBinding.laptopsRecyclerview.setAdapter(laptopsAdapter);
    }

    private void getLaptops() {
        activityMainBinding.setIsLoading(true);
        viewModel.getLaptops().observe(this, laptopsResponse -> {
            activityMainBinding.setIsLoading(false);
            if(laptopsResponse != null){
                laptops.clear();
                laptops.addAll(laptopsResponse);
                laptopsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        changesRecyclerLayoutManager(newConfig);
    }

    private void changesRecyclerLayoutManager(Configuration newConfig) {
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activityMainBinding.laptopsRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            activityMainBinding.laptopsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    public void onLaptopClick(Laptop laptop) {
        Intent intent = new Intent(getApplicationContext(), LaptopDetailActivity.class);
        intent.putExtra("title", laptop.getTitle());
        intent.putExtra("description", laptop.getDescription());
        intent.putExtra("image", laptop.getImage());
        startActivity(intent);
    }
}