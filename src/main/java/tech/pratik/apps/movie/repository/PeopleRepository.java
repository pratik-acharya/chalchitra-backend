package tech.pratik.apps.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.pratik.apps.movie.domain.People;

/**
 * Created by Pratik on 2/21/17.
 */
@RepositoryRestResource
public interface PeopleRepository extends CrudRepository<People,Long>{
}
