package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
    @Id
    private Long id;
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
