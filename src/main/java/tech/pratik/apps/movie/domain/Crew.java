package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;
    @ManyToMany(mappedBy = "crews")
    private List<Movie> movie;
}
