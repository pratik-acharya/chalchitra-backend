package tech.pratik.apps.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tech.pratik.apps.user.domain.User;

/**
 * Created by Pratik on 3/16/17.
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);



}
