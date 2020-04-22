package com.application.reds.ui.property;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reds.R;
import com.application.reds.model.property.Property;
import com.application.reds.model.property.PropertyAdapter;
import com.application.reds.model.property.PropertyAdapterListener;
import com.application.reds.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PropertyFragment extends Fragment implements PropertyAdapterListener, NavigationView.OnNavigationItemSelectedListener {

    private View view;
    private RecyclerView recyclerView;
    public static ArrayList<Property> propertList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_property, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        bindViews();
        initData();

        return view;
    }

    private void bindViews() {
        recyclerView = view.findViewById(R.id.list_property);

        PropertyAdapter adapter = new PropertyAdapter(propertList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        propertList.clear();
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.property1) + '/' +
                getResources().getResourceTypeName(R.drawable.property1) + '/' +
                getResources().getResourceEntryName(R.drawable.property1));

        Uri imageUri3 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.property3) + '/' +
                getResources().getResourceTypeName(R.drawable.property3) + '/' +
                getResources().getResourceEntryName(R.drawable.property3));


        Property property = new Property(
                1,
                getResources().getString(R.string.house_name_value) + "",
                getResources().getString(R.string.location_value) + "",
                getResources().getString(R.string.address_value),
                getResources().getString(R.string.status_value) + "",
                getResources().getString(R.string.house_name_value) + "",
                Integer.parseInt(getResources().getString(R.string.bedroom_value) + ""),
                Integer.parseInt(getResources().getString(R.string.bathroom_value) + ""),
                500,
                650,
                2000000000,
                getResources().getString(R.string.type_value) + "",
                getResources().getString(R.string.facility_value) + "",
                imageUri
        );

        Property property3 = new Property(
                2,
                "Villa Mewah Bali",
                "Canggu, Bali",
                "Jl. Raya canggu no 10",
                "Tersedia",
                "Full Furnished",
                3,
                3,
                700,
                400,
                1900000000,
                "Villa",
                "Kolam Renang, Dapur Bersih dan Dapur Kotor, Garasi, Air Sumur dan PAM",
                imageUri3
        );

        Property komplek = new Property(
                3,
                "Komplek Ciumbuleuit",
                "Ciumbuleuit, Bandung",
                "Jl. Raya Ciumbuleuit no 99",
                "Tersedia",
                "- Full Furnished \n- SHM",
                3,
                3,
                400,
                350,
                1900000000,
                "Villa",
                "Kolam Renang, Dapur Bersih dan Dapur Kotor, Garasi, Air Sumur dan PAM",
                imageUri3
        );

        propertList.add(property);
        propertList.add(property3);
        propertList.add(komplek);

    }


    @Override
    public void onItemSelected(Property data) {
        Intent intent = new Intent(getContext(), DetailProperty.class);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(getContext(), "tes", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
