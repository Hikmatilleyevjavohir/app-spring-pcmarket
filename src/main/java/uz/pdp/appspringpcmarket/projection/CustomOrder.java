package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Basket;
import uz.pdp.appspringpcmarket.entity.BasketProduct;
import uz.pdp.appspringpcmarket.entity.Order;
import uz.pdp.appspringpcmarket.entity.User;

import java.sql.Timestamp;

@Projection(types = Order.class)
public interface CustomOrder {
    Integer getId();

    Timestamp getOrderDate();

    BasketProduct getBasketProduct();

    User getUser();
}
