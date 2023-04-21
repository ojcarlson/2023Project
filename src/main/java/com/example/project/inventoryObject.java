package com.example.project;

import java.util.ArrayList;

public class inventoryObject {
    String buildingLocation;
    String heci;
    String description;
    double cost;
    double bayLocation;
    String status;
    int quantity;



    public inventoryObject(String buildingLocation, String heci, String description, double Cost, double bayLocation, String status, int quantity) {
        this.buildingLocation = buildingLocation;
        this.heci = heci;
        this.description = description;
        this.cost = cost;
        this.bayLocation = bayLocation;
        this.status = status;
        this.quantity = quantity;
    }

}
