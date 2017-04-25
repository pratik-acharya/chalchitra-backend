package tech.pratik.apps.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.pratik.apps.movie.domain.Occupation;

/**
 * Created by Pratik on 2/21/17.
 */
public interface OccupationRepository extends CrudRepository<Occupation,Long>{
}
