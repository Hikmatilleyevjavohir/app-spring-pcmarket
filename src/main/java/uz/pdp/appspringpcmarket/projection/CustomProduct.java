package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Attachment;
import uz.pdp.appspringpcmarket.entity.Product;
import uz.pdp.appspringpcmarket.entity.Property;


@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    String getDiscription();

    Double getPrice();

    Attachment getPhoto();
}
