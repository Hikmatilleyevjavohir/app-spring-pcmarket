package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Basket;
import uz.pdp.appspringpcmarket.entity.BasketProduct;
import uz.pdp.appspringpcmarket.entity.Product;

@Projection(types = BasketProduct.class)
public interface CustomBasketProduct {
    Integer getId();

    Basket getBasket();

    Product getProduct();

    Double getAmount();
}
