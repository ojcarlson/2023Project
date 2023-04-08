import java.io.Serializable;
//test
public class BuildingLocation implements Serializable {
    protected String buildingLocation;

    //constructor for buildingLocation
    BuildingLocation() {
        this.buildingLocation = "NE2054";
    }
    BuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation;
    }
    //mutator to set and get buildingLocation number
    public void setBuildingLocation(String newBuildingLocation) {
        buildingLocation = newBuildingLocation;
    }

    public String getBuildingLocation(){
        return buildingLocation;
    }
    @Override
    public String toString() {
        return String.format ("Building Location:    %s", buildingLocation);
    }
}
