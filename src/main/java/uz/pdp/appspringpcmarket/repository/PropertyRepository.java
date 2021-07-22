package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Property;
import uz.pdp.appspringpcmarket.projection.CustomProperty;

@RepositoryRestResource(path = "property", excerptProjection= CustomProperty.class)
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
