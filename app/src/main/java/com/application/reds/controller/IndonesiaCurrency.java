package com.application.reds.controller;

import java.text.NumberFormat;
import java.util.Locale;

public class IndonesiaCurrency {

    public String formatRupiah(double nominal){
        String res;
        Locale localeID = new Locale("in", "ID");
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(localeID);
        res = rupiah.format(nominal);
        return res;
    }
}
