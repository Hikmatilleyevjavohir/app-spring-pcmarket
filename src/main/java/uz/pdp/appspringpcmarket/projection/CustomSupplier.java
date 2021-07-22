package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Product;
import uz.pdp.appspringpcmarket.entity.Supplier;
import java.util.List;

@Projection(types = Supplier.class)
public interface CustomSupplier {
    Integer getId();

    String getFullName();

    String getPhoneNumber();

    List<Product> getProducts();
}
