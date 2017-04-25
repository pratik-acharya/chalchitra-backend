package tech.pratik.apps.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.pratik.apps.user.domain.Role;
import tech.pratik.apps.user.domain.RoleName;

/**
 * Created by Pratik on 3/18/17.
 */
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Long>{
    public Role findByName(RoleName name);
}
