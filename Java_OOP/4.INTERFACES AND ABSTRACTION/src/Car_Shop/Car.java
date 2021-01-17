package Car_Shop;

import java.io.Serializable;

public interface Car extends Serializable {
    int TIRE = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
