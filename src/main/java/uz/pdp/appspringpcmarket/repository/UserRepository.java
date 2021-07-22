package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.User;
import uz.pdp.appspringpcmarket.projection.CustomUser;

@RepositoryRestResource(path = "user", excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User, Integer> {
}
