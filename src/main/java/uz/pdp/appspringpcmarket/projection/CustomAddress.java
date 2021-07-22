package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Address;

@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();

    String getStreetName();

    Integer getHouseNumber();
}
