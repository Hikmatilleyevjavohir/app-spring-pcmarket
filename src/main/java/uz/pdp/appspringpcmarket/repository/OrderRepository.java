package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Order;
import uz.pdp.appspringpcmarket.projection.CustomOrder;

@RepositoryRestResource(path = "order", excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
