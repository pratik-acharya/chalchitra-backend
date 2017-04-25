package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String name;
   @ManyToMany(mappedBy = "genres")
   private List<Movie> movies;
}
