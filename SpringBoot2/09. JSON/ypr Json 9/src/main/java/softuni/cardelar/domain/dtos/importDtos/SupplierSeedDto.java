package softuni.cardelar.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;

public class SupplierSeedDto {

    @Expose
    private String name;

    @Expose
    private boolean isImportant;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
