package com.application.reds.model.property;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reds.R;
import com.application.reds.ui.IndonesiaCurrency;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.MyViewHolder> {

    private List<Property> propertyList;
    private PropertyAdapterListener adapterListener;
    IndonesiaCurrency kurs = new IndonesiaCurrency();

    public PropertyAdapter(List<Property> propertyList, PropertyAdapterListener listener){
        this.adapterListener = listener;
        this.propertyList = propertyList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_property, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Property item = propertyList.get(position);

        // set holder view
        holder.name.setText(item.getName());
        holder.location.setText(item.getLocation());
        holder.bedroom.setText(item.getBedroom() + " KT - ");
        holder.bathroom.setText(item.getBathroom() + " KM ");
        holder.surface_area.setText(Html.fromHtml("LT : " + item.getSurface_area() + " m<sup><small>2</small></sup>"));
        holder.building_area.setText(Html.fromHtml(" LB : " + item.getBuilding_area() + " m<sup><small>2</small></sup>"));
        holder.price.setText(kurs.formatRupiah(item.getPrice()));
        holder.imageView.setImageURI(item.getImage());
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, location, bedroom, bathroom, surface_area, building_area, price;
        private ImageView imageView;

        MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name_row_property);
            location = view.findViewById(R.id.location_row_property);
            bedroom = view.findViewById(R.id.bedroom_row_property);
            bathroom = view.findViewById(R.id.bathroom_row_property);
            surface_area = view.findViewById(R.id.surface_area_row_property);
            building_area = view.findViewById(R.id.building_area_row_property);
            price = view.findViewById(R.id.price_row_property);
            imageView = view.findViewById(R.id.image_row_property);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterListener.onItemSelected(propertyList.get(getAdapterPosition()));
                }
            });
        }
    }
}
