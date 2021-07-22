package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Basket;
import uz.pdp.appspringpcmarket.entity.Product;

import javax.persistence.OneToMany;
import java.util.List;

@Projection(types = Basket.class)
public interface CustomBasket {
    Integer getId();

    Double getPrice();

    String getTotal();

    String getQuantity();

    Double getOrderAllPrice();

    List<Product> getProductList();
}
