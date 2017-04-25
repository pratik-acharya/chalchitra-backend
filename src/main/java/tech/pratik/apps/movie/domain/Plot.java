package tech.pratik.apps.movie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String title;
    private String description;
}
