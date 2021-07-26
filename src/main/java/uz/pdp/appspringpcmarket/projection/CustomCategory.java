package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Category;
import uz.pdp.appspringpcmarket.entity.Product;


import java.util.List;

@Projection(types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();

    String getDiscription();

    Category getParentCategory();
}
