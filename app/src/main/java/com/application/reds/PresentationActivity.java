package com.application.reds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PresentationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        BottomNavigationView navView = findViewById(R.id.nav_bottom_presentation_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_bottom_host_presentation_fragment);
        NavigationUI.setupWithNavController(navView, navController);

    }
}
