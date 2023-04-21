package com.example.project;

public class InventoryAccount extends Inventory{

    InventoryAccount(String heci, String description, Double cost, Double bayLocation,
                     String status, int quantity, BuildingLocation buildingLocation) {
        super(buildingLocation, heci, description, cost, bayLocation, status, quantity
        );
    }

}
