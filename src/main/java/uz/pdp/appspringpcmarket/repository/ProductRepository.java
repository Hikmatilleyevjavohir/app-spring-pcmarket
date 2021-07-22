package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Product;
import uz.pdp.appspringpcmarket.projection.CustomProduct;

@RepositoryRestResource(path = "product", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
