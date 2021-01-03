package softuni.cardealer.domain.dtos.export;

import com.google.gson.annotations.Expose;
import softuni.cardealer.domain.entities.Part;

import java.util.List;
import java.util.Set;

public class CarAndPartExportDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private String travelledDistance;
    @Expose
    private List<PartExportDto> parts;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartExportDto> getParts() {
        return parts;
    }

    public void setParts(List<PartExportDto> parts) {
        this.parts = parts;
    }
}
