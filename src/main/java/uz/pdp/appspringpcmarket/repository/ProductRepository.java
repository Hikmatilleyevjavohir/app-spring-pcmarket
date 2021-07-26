package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.appspringpcmarket.entity.Product;
import uz.pdp.appspringpcmarket.projection.CustomProduct;

import java.util.List;

@RepositoryRestResource(path = "product", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value =
            "select * from property prop " +
                    "where prop.id in (brendId, operativXotiraId, protsessId, EkranDiagonalId, SSDId, videoKardId, qattiqDiskId)")
    List<Product> getAllProductByFilter(Integer brendId, Integer operativXotiraId, Integer protsessId, Integer EkranDiagonalId, Integer SSDId, Integer videoKardId, Integer qattiqDiskId);

    @RestResource(path = "byName")
    Page<Product> findAllByName(@Param("name") String firstName, Pageable pageable);

    @RestResource(path = "byPrice")
    Page<Product> findAllByPrice(@Param("price") Double price, Pageable pageable);
}
