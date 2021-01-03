package softuni.cardealer.domain.dtos.export;

import com.google.gson.annotations.Expose;
import softuni.cardealer.domain.entities.Part;

import java.util.Set;

public class SupplierExportDto {

    @Expose
    private long id;
    @Expose
    private String name;
    @Expose
    private int partsCount;

    public SupplierExportDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
