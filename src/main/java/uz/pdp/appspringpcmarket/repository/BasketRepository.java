package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Basket;
import uz.pdp.appspringpcmarket.projection.CustomBasket;

@RepositoryRestResource(path = "basket", excerptProjection = CustomBasket.class)
public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
