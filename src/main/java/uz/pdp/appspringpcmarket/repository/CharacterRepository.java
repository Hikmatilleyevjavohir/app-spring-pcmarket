package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.appspringpcmarket.entity.Category;
import uz.pdp.appspringpcmarket.projection.CustomCategory;
import uz.pdp.appspringpcmarket.projection.CustomCharacter;

@RepositoryRestResource(path = "character", excerptProjection = CustomCharacter.class)
public interface CharacterRepository extends JpaRepository<Category, Integer> {
    @RestResource(path = "byName")
    Page<Category> findAllByName(@Param("name") String name, Pageable pageable);
}
