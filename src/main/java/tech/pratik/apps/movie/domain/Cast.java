package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cast_character")
    private String character;
    @Column(name="cast_order")
    private long order;
    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;

    @ManyToMany(mappedBy = "casts")
    private List<Movie> movies;
}
