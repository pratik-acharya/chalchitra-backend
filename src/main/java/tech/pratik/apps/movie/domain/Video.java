package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String source_key;
    private String site;
    @Enumerated(EnumType.STRING)
    private VideoType  type;
    private Date date;
}
