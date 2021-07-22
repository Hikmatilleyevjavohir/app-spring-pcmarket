package uz.pdp.appspringpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringpcmarket.entity.Attachment;
import uz.pdp.appspringpcmarket.entity.Blog;

@Projection(types = Blog.class)
public interface CustomBlog {
    Integer getId();

    String getText();

    Attachment getAttachment();
}
