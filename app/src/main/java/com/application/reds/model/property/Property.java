package com.application.reds.model.property;

import android.net.Uri;

public class Property {

    private int id;
    private String name;
    private String location;
    private String address;
    private String status;
    private String description;
    private int bedroom;
    private int bathroom;
    private int surface_area;
    private int building_area;
    private int price;
    private String type;
    private String facility;
    private Uri image;

    public Property(){}

    public Property(int id, String name, String location, String address, String status, String description, int bedroom, int bathroom, int surface_area, int building_area, int price, String type, String facility, Uri uri) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.status = status;
        this.description = description;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.surface_area = surface_area;
        this.building_area = building_area;
        this.price = price;
        this.type = type;
        this.facility = facility;
        this.image = uri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(int surface_area) {
        this.surface_area = surface_area;
    }

    public int getBuilding_area() {
        return building_area;
    }

    public void setBuilding_area(int building_area) {
        this.building_area = building_area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
