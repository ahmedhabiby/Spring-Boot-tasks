package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City {
    @Id
    
    private Long id;
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
