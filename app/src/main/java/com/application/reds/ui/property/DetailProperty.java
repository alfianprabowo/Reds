package com.application.reds.ui.property;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.application.reds.MainActivity;
import com.application.reds.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailProperty extends AppCompatActivity {

    CarouselView carouselView;
    private TextView name_tv, location_tv, price_tv, status_tv, bedroom_tv, bathroom_tv, surface_tv, building_tv, floor_tv, type_tv, facility_tv, description_tv;


    int[] sampleImages = {R.drawable.property1, R.drawable.property1a, R.drawable.property1b};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_property);

        bindViews();
    }

    private void bindViews(){
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void back(View view) {
        finish();
    }
}
