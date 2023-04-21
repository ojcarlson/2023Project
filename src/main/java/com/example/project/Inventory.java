package com.example.project;

import java.io.Serializable;
public class Inventory implements Serializable{

    protected String heci;
    protected String description;
    protected Double cost;
    protected Double bayLocation;
    protected String status;
    protected int quantity;
    protected BuildingLocation buildingLocation;

    Inventory() {
        this.heci = "SQPQ00194";
        this.description = "Mon NEC";
        this.cost = 1023.25;
        this.bayLocation = 010003.09;
        this.status = "Installed";
        this.quantity = 10;
    }
    Inventory(BuildingLocation buildingLocation, String heci, String description, Double cost, Double bayLocation, String status,
              int quantity)
    {
        this.heci = heci;
        this.description = description;
        this.cost = cost;
        this.bayLocation = bayLocation;
        this.status = status;
        this.quantity = quantity;
        this.buildingLocation = buildingLocation;
    }
    public void setHeci (String newHeci) {
        heci = newHeci;
    }

    public String getHeci() {
        return heci;
    }

    public void setDescription (String newDescription) {
        description = newDescription;
    }

    public String getDescription() {
        return description;
    }
    public void setCost (Double newCost) {
        cost = newCost;
    }

    public Double getCost() {
        return cost;
    }

    public void setBayLocation (Double newBayLocation) {
        bayLocation = newBayLocation;
    }

    public Double getBayLocation() {
        return bayLocation;
    }

    public void setStatus (String newStatus) {
        status = newStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setQuantity (int newQuantity) {
        quantity = newQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBuildingLocation(BuildingLocation newBuildingLocation) {
        buildingLocation = newBuildingLocation;
    }

    public BuildingLocation getBuildingLocation() {
        return buildingLocation;
    }

    @Override
    public String toString() {
        return String.format("Building Location     Heci     Description     Cost     BayLocation     Status     Quanity     " +
                String.format("\n_____________________________________") + String.format("\n%s     ", buildingLocation)
                + String.format("%s     ", heci) + String.format("%s     ", description) + String.format("%s     ", cost)
                + String.format("%s     ", bayLocation) + String.format("%s     ", status) + String.format("%s     \n", quantity)
        );
    }


}

