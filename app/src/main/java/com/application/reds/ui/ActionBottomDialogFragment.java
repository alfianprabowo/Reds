package com.application.reds.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.application.reds.R;
import com.application.reds.controller.IndonesiaCurrency;
import com.application.reds.model.facility.Facility;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class ActionBottomDialogFragment extends BottomSheetDialogFragment
        implements View.OnClickListener  {

    public static final String TAG = "ActionBottomDialog";
    private View view;
    IndonesiaCurrency kurs;
    private Button[] btn = new Button[5];
    private Button btn_unfocus;
    private int[] btn_id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4};

    private Button[] btn_bedroom = new Button[5];
    private Button btn_unfocus_bedroom;
    private int[] btn_bedroom_id = {R.id.button_bedroom_all, R.id.button_bedroom_1, R.id.button_bedroom_2, R.id.button_bedroom_3, R.id.button_bedroom_4};

    private ListView llChb;

    private String[] data = { "AC", "Carport", "Garden", "Pool"};
    private ArrayList<String> arrData=null;

    private ArrayList<Facility> infodata;

    public static ActionBottomDialogFragment newInstance() {
        return new ActionBottomDialogFragment();
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_filter, container, false);
        kurs = new IndonesiaCurrency();
        bindViews();

        return view;
    }

    private void bindViews(){
        final CrystalRangeSeekbar rangeSeekbar =  view.findViewById(R.id.seekbar_price_dialog_filter);

        // get min and max text view
        final TextView tvMin =  view.findViewById(R.id.min_price_range);
        final TextView tvMax =  view.findViewById(R.id.max_price_range);

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(kurs.formatRupiah(Double.parseDouble(String.valueOf(minValue))));
                tvMax.setText(kurs.formatRupiah(Double.parseDouble(String.valueOf(maxValue))));
            }
        });

        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                //Toast.makeText(getContext(), "min : " + minValue + " , max : " + maxValue, Toast.LENGTH_SHORT).show();
                Log.d("CRS=>", minValue + " : " + maxValue);
            }
        });


        // Button Property Types
        for(int i = 0; i < btn.length; i++){
            btn[i] = view.findViewById(btn_id[i]);
            btn[i].setBackgroundColor(Color.TRANSPARENT);
            btn[i].setTextColor(Color.rgb(49, 50, 51));
            btn[i].setOnClickListener(this);
        }

        btn_unfocus = btn[0];
        setFocus(btn_unfocus, btn[0]);

        // Button Bedrooms
        for(int i = 0; i < btn_bedroom.length; i++){
            btn_bedroom[i] = view.findViewById(btn_bedroom_id[i]);
            btn_bedroom[i].setBackgroundColor(Color.TRANSPARENT);
            btn_bedroom[i].setTextColor(Color.rgb(49, 50, 51));
            btn_bedroom[i].setOnClickListener(this);
        }

        btn_unfocus_bedroom = btn_bedroom[0];
        setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[0]);

        initData();
    }

    private void initData(){
        arrData = new ArrayList<>();
        arrData.add("AC");
        arrData.add("Carport");
        arrData.add("Garden");
        arrData.add("Pool");
        llChb =  view.findViewById(R.id.listview_facility_dialog_filter);

        infodata = new ArrayList<Facility>();
        for (int i = 0; i < data.length; i++) {
            infodata.add(new Facility(false, i));
        }
        llChb.invalidate();
        llChb.setAdapter(new MyAdapter());
    }

    @Override
    public void onClick(View v) {
        TextView tvSelected = (TextView) v;
        String selected = tvSelected.getText().toString();

        switch (v.getId()){
            // BUTTON TYPE
            case R.id.btn0 :
                setFocus(btn_unfocus, btn[0]);
                break;

            case R.id.btn1 :
                setFocus(btn_unfocus, btn[1]);
                break;

            case R.id.btn2 :
                setFocus(btn_unfocus, btn[2]);
                break;

            case R.id.btn3 :
                setFocus(btn_unfocus, btn[3]);
                break;

            case R.id.btn4 :
                setFocus(btn_unfocus, btn[4]);
                break;

            case R.id.reset_button_dialog_filter :
                //mListener.onItemClick(selected);
                Toast.makeText(getContext(), "Reset filters" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.done_button_dialog_filter :
                //mListener.onItemClick(selected);
                dismiss();
                break;

            case R.id.button_bedroom_all :
                setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[0]);
                break;

            case R.id.button_bedroom_1 :
                setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[1]);
                break;

            case R.id.button_bedroom_2 :
                setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[2]);
                break;

            case R.id.button_bedroom_3 :
                setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[3]);
                break;

            case R.id.button_bedroom_4 :
                setFocusBedroom(btn_unfocus_bedroom, btn_bedroom[4]);
                break;
        }
    }

    private void setFocus(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51));
        btn_unfocus.setBackgroundColor(Color.TRANSPARENT);
        btn_focus.setTextColor(Color.rgb(255, 255, 255));
        btn_focus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
        this.btn_unfocus = btn_focus;
    }

    private void setFocusBedroom(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51));
        btn_unfocus.setBackgroundColor(Color.TRANSPARENT);
        btn_focus.setTextColor(Color.rgb(255, 255, 255));
        btn_focus.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
        this.btn_unfocus_bedroom = btn_focus;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.reset_button_dialog_filter).setOnClickListener(this);
        view.findViewById(R.id.done_button_dialog_filter).setOnClickListener(this);

    }

    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        ItemClickListener mListener = null;
    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View row = null;
            row = View.inflate(getContext(), R.layout.row_facility_filter, null);
            TextView tvContent= row.findViewById(R.id.tvContent);
            tvContent.setText(data[position]);

            final CheckBox cb = row.findViewById(R.id.chbContent);
            cb.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    infodata.get(position).isclicked = !infodata.get(position).isclicked;

                    for(int i=0;i<infodata.size();i++)
                    {
                        if (infodata.get(i).isclicked)
                        {
                            System.out.println("Selectes Are == "+ data[i]);
                        }
                    }
                }
            });

            if (infodata.get(position).isclicked) {

                cb.setChecked(true);
            }
            else {
                cb.setChecked(false);
            }
            return row;
        }

    }
}
