package com.application.reds.ui.transaction;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.application.reds.R;

public class TransactionProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_progress);

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
