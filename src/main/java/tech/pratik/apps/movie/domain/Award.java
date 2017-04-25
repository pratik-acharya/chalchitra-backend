package tech.pratik.apps.movie.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pratik on 2/20/17.
 */
@Entity
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    @OneToOne
    @JoinColumn(name = "award_information_id")
    private AwardInformation awardInformation;

}
