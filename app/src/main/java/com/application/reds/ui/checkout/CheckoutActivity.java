package com.application.reds.ui.checkout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.application.reds.R;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener{

    private Button[] btn = new Button[2];
    private Button btn_unfocus;
    private int[] btn_id = {R.id.btn_checkout_escrow, R.id.btn_checkout_mpos};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        bindViews();
    }

    private void bindViews(){
        for (int i = 0; i < btn.length; i++) {
            btn[i] = findViewById(btn_id[i]);
            btn[i].setBackgroundColor(Color.TRANSPARENT);
            btn[i].setTextColor(Color.rgb(49, 50, 51));
            btn[i].setOnClickListener(this);
        }

        btn_unfocus = btn[0];
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // BUTTON TYPE
            case R.id.btn_checkout_escrow:
                setFocus(btn_unfocus, btn[0]);
                break;

            case R.id.btn_checkout_mpos:
                setFocus(btn_unfocus, btn[1]);
                break;
        }
    }

    private void setFocus(Button btn_unfocus, Button btn_focus) {
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51));
        btn_unfocus.setBackgroundColor(Color.TRANSPARENT);
        btn_focus.setTextColor(Color.rgb(255, 255, 255));
        btn_focus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
        this.btn_unfocus = btn_focus;
    }
}
