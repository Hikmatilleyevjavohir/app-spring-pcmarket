package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.projection.CustomAddress;

@RepositoryRestResource(path = "address", excerptProjection = CustomAddress.class)
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
