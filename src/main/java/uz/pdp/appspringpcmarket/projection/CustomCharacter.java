package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Character;

@Projection(types = Character.class)
public interface CustomCharacter {

    Integer getId();

    String getName();
}
