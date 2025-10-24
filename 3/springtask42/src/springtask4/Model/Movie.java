package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
    @Id
    private Long id;
    private String movieTitle;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
}
