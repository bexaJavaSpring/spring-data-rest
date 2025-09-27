package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.java.springdatarest.model.Post;
@RepositoryRestResource(path = "posts")
public interface PostRepository extends JpaRepository<Post, Long> {
}
