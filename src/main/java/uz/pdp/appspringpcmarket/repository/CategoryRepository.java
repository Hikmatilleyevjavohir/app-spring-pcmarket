package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Category;
import uz.pdp.appspringpcmarket.projection.CustomCategory;

@RepositoryRestResource(path = "category", excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @RestResource(path = "byName")
    Page<Category> findAllByName(@Param("name") String name, Pageable pageable);
}
