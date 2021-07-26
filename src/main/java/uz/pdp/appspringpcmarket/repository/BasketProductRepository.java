package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.appspringpcmarket.entity.Basket;
import uz.pdp.appspringpcmarket.projection.CustomBasket;
import uz.pdp.appspringpcmarket.projection.CustomBasketProduct;

@RepositoryRestResource(path = "basketProduct", excerptProjection = CustomBasketProduct.class)
public interface BasketProductRepository extends JpaRepository<Basket, Integer> {
}
