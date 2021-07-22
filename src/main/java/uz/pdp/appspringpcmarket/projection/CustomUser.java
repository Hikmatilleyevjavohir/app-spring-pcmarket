package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.User;


@Projection(types = User.class)
public interface CustomUser {
    Integer getId();

    String getFullName();

    String getPhoneNumber();

    String getEmail();

    Address getAddress();
}
