package com.example.mobiletechnicaltest.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiletechnicaltest.R;
import com.example.mobiletechnicaltest.databinding.ItemContainerLaptopsBinding;
import com.example.mobiletechnicaltest.listeners.LaptopListener;
import com.example.mobiletechnicaltest.models.Laptop;

import java.util.List;

public class LaptopsAdapter extends RecyclerView.Adapter<LaptopsAdapter.LaptopViewHolder> {

    private List<Laptop> laptops;
    private LayoutInflater layoutInflater;
    private LaptopListener laptopListener;

    public LaptopsAdapter(List<Laptop> laptops, LaptopListener laptopListener) {
        this.laptops = laptops;
        this.laptopListener = laptopListener;
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerLaptopsBinding laptopsBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_container_laptops, parent, false);
        return new LaptopViewHolder(laptopsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {
        holder.bindLaptop(laptops.get(position));
    }

    @Override
    public int getItemCount() {
        return laptops.size();
    }


    class LaptopViewHolder extends RecyclerView.ViewHolder {
        private ItemContainerLaptopsBinding itemContainerLaptopsBinding;

        public LaptopViewHolder(ItemContainerLaptopsBinding itemContainerLaptopsBinding) {
            super(itemContainerLaptopsBinding.getRoot());
            this.itemContainerLaptopsBinding = itemContainerLaptopsBinding;
        }

        public void bindLaptop(Laptop laptop){
            itemContainerLaptopsBinding.setLaptop(laptop);
            itemContainerLaptopsBinding.executePendingBindings();
            itemContainerLaptopsBinding.getRoot().setOnClickListener(v -> laptopListener.onLaptopClick(laptop));
        }
    }
}
