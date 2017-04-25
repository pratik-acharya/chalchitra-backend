package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    @Lob
    private String description;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    @ManyToMany
    @JoinTable(name = "people_occupation",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "occupation_id"))
    private List<Occupation> occupations;

}
