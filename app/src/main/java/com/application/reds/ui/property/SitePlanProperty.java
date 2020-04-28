package com.application.reds.ui.property;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.application.reds.R;

public class SitePlanProperty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteplan);


    }

    public void back(View view) {
        finish();
    }

    public void detailProperty(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailProperty.class);
        intent.putExtra("property", 3 + "");
        startActivity(intent);
    }
}
