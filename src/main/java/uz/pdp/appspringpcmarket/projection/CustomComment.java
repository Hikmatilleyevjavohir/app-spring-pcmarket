package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Comment;
import uz.pdp.appspringpcmarket.entity.User;

@Projection(types = Comment.class)
public interface CustomComment {
    Integer getId();

    String getMessage();

    User getUser();
}
