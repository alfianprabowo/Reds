package com.application.reds.ui.notification;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.application.reds.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


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
