package tech.pratik.apps.movie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.pratik.apps.movie.domain.Movie;

/**
 * Created by Pratik on 2/19/17.
 */

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends JpaRepository<Movie,Long>{

    //Page<Movie> findByTitle(@Param("title") String title);



}
