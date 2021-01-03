package softuni.productshop.domain.dtos.importedDtos;

import com.google.gson.annotations.Expose;

public class CategoriesImportDto {

    @Expose
    private String name;

    public CategoriesImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
