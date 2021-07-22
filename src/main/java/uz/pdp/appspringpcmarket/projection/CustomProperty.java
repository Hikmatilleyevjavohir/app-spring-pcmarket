package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Property;

@Projection(types = Property.class)
public interface CustomProperty {
    Integer getId();

    String getName();

    String getText();
}
