package com.application.reds.model.facility;

import android.net.Uri;

public class Facility {

    public boolean isclicked=false;
    public int index;

    public Uri image;
    /*public String fanId;
    public String strAmount;*/

    public Facility(boolean isclicked,int index, Uri image)
    {
        this.index=index;
        this.isclicked=isclicked;
        this.image = image;
    }


}
