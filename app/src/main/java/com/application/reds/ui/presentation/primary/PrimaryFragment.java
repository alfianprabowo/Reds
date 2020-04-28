package com.application.reds.ui.presentation.primary;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reds.R;
import com.application.reds.model.property.Property;
import com.application.reds.model.property.PropertyAdapter;
import com.application.reds.model.property.PropertyAdapterListener;
import com.application.reds.ui.ActionBottomDialogFragment;
import com.application.reds.ui.property.DetailProperty;

import java.util.ArrayList;

public class PrimaryFragment extends Fragment implements PropertyAdapterListener, ActionBottomDialogFragment.ItemClickListener{

    private View view;
    private static ArrayList<Property> propertList = new ArrayList<>();
    private CardView filter_button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_presentation_primary, container, false);

        bindViews();
        initData();
        initActionButtons();

        return view;
    }

    private void initActionButtons() {
        filter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBottomDialogFragment addPhotoBottomDialogFragment = ActionBottomDialogFragment.newInstance();
                addPhotoBottomDialogFragment.show(getParentFragmentManager(), ActionBottomDialogFragment.TAG);
            }
        });
    }

    private void bindViews() {
        RecyclerView recyclerView = view.findViewById(R.id.list_primary_presentation);

        PropertyAdapter adapter = new PropertyAdapter(propertList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        filter_button = view.findViewById(R.id.filter_cardview_primary_presentation);
    }

    private void initData() {
        propertList.clear();
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.property4) + '/' +
                getResources().getResourceTypeName(R.drawable.property4) + '/' +
                getResources().getResourceEntryName(R.drawable.property4));



        Property property = new Property(
                1,
                "Rumah Mewah Bandung",
                "Soekarno Hatta, Bandung",
                "Jl. Soekarno Hatta no 1, Bandung",
                getResources().getString(R.string.status_value) + "",
                getResources().getString(R.string.house_name_value) + "",
                3,
                3,
                400,
                350,
                1500000000,
                getResources().getString(R.string.type_value) + "",
                getResources().getString(R.string.facility_value) + "",
                imageUri
        );

        propertList.add(property);

    }

    @Override
    public void onItemClick(String item) {
        //Toast.makeText(getContext(), " tes dialog", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(Property data) {
        Intent intent = new Intent(getContext(), DetailProperty.class);
        intent.putExtra("property", data.getId() + "");
        startActivity(intent);
    }
}
