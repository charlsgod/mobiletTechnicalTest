package com.example.mobiletechnicaltest.utilities;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.mobiletechnicaltest.R;

public class BindingAdapters {

    @BindingAdapter("android:imageURL")
    public static void setImageURL(ImageView imageView, String URL) {
        Glide.with(imageView.getContext())
                .load(URL)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView);
    }
}
