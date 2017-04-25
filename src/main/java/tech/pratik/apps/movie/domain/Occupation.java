package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    @ManyToMany(mappedBy = "occupations")
    private List<People> peoples;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }
}
