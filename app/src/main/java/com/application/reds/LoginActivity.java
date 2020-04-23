package com.application.reds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout input_username, input_password;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        initActionButtons();
    }

    private void bindViews(){
        input_username = findViewById(R.id.username_login);
        input_password = findViewById(R.id.password_login);
        button_login = findViewById(R.id.button_login);
    }

    private void initActionButtons(){

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ModeActivity.class);
                startActivity(intent);
            }
        });
    }
}
