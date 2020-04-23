package com.application.reds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BrokerActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker);

        BottomNavigationView navView = findViewById(R.id.nav_bottom_broker_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_bottom_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

    }


}
