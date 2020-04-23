package com.application.reds.ui.presentation.property;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reds.R;
import com.application.reds.model.property.Property;
import com.application.reds.model.property.PropertyAdapter;
import com.application.reds.model.property.PropertyAdapterListener;
import com.application.reds.ui.property.DetailProperty;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PropertyFragment extends Fragment implements PropertyAdapterListener, NavigationView.OnNavigationItemSelectedListener {

    private View view;
    private RecyclerView recyclerView;
    public static ArrayList<Property> propertList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_presentation_property, container, false);

        bindViews();
        initData();

        return view;
    }

    private void bindViews() {
        recyclerView = view.findViewById(R.id.list_property_presentation);

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

        Uri imageUri2 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.property3) + '/' +
                getResources().getResourceTypeName(R.drawable.property3) + '/' +
                getResources().getResourceEntryName(R.drawable.property3));

        Uri imageUri3 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.siteplan2) + '/' +
                getResources().getResourceTypeName(R.drawable.siteplan2) + '/' +
                getResources().getResourceEntryName(R.drawable.siteplan2));


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

        Property property2 = new Property(
                2,
                "Villa Mewah Bali",
                "Canggu, Bali",
                "Jl. Raya canggu no 10",
                "Available",
                "Full Furnished",
                3,
                3,
                700,
                400,
                1900000000,
                "Villa",
                "Pool, Dapur Bersih dan Dapur Kotor, Garage, Air Sumur dan PAM",
                imageUri2
        );

        Property komplek = new Property(
                3,
                "Komplek Ciumbuleuit",
                "Ciumbuleuit, Bandung",
                "Jl. Raya Ciumbuleuit no 99",
                "Available",
                "- Full Furnished \n- SHM",
                3,
                3,
                400,
                350,
                1900000000,
                "Real Estate",
                "Lake, Garden, Minimarket, Jogging Track ",
                imageUri3
        );

        propertList.add(property);
        propertList.add(property2);
        propertList.add(komplek);

    }


    @Override
    public void onItemSelected(Property data) {
        Intent intent = new Intent(getContext(), DetailProperty.class);
        intent.putExtra("property", data.getId() + "");
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
