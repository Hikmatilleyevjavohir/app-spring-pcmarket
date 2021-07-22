package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Blog;
import uz.pdp.appspringpcmarket.projection.CustomBlog;

@RepositoryRestResource(path = "blog", excerptProjection = CustomBlog.class)
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
