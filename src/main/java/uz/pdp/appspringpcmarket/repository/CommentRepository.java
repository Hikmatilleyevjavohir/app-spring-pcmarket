package uz.pdp.appspringpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringpcmarket.entity.Address;
import uz.pdp.appspringpcmarket.entity.Comment;
import uz.pdp.appspringpcmarket.projection.CustomComment;

@RepositoryRestResource(path = "comment", excerptProjection = CustomComment.class)
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
