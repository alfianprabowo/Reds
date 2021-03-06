package com.application.reds.ui.property;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.application.reds.MainActivity;
import com.application.reds.R;
import com.application.reds.ui.checkout.CheckoutActivity;
import com.application.reds.ui.customer.CustomerFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Objects;

public class DetailProperty extends AppCompatActivity {

    CarouselView carouselView;
    private TextView name_tv, location_tv, price_tv, status_tv, bedroom_tv, bathroom_tv, surface_tv, building_tv, floor_tv, type_tv, facility_tv, description_tv;
    private Button button_pay;

    int[] sampleImages = {R.drawable.property1, R.drawable.property1a, R.drawable.property1b};
    int[] sampleImages2 = {R.drawable.property3, R.drawable.property1a, R.drawable.property1b};
    int[] sampleImages3 = {R.drawable.site_a_floor, R.drawable.site_a_bed, R.drawable.site_a_bath };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_property);

        bindViews();
    }

    private void bindViews(){
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        Intent intent = getIntent();
        final int property = Integer.parseInt(intent.getStringExtra("property"));
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                if(property == 1 ){
                    imageView.setImageResource(sampleImages[position]);
                }else if(property == 2) {
                    imageView.setImageResource(sampleImages2[position]);
                }else if(property == 3) {
                    imageView.setImageResource(sampleImages3[position]);
                }
            }
        };

        carouselView.setImageListener(imageListener);
        button_pay = findViewById(R.id.button_pay);
        button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), CheckoutActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void back(View view) {
        finish();
    }
}
