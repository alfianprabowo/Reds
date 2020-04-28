package com.application.reds.model.property;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reds.R;
import com.application.reds.controller.IndonesiaCurrency;

import java.util.ArrayList;
import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.MyViewHolder> implements Filterable {

    private List<Property> propertyList;
    private List<Property> propertyListFiltered;
    private PropertyAdapterListener adapterListener;
    private IndonesiaCurrency kurs = new IndonesiaCurrency();

    public PropertyAdapter(List<Property> propertyList, PropertyAdapterListener listener){
        this.adapterListener = listener;
        this.propertyList = propertyList;
        this.propertyListFiltered = propertyList;
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
        return propertyListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    propertyListFiltered = propertyList;
                } else {
                    List<Property> filteredList = new ArrayList<>();
                    for (Property row : propertyList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    propertyListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = propertyListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                propertyListFiltered = (ArrayList<Property>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
