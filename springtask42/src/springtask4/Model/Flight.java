package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {
    @Id 
    private Long id;
    private String flightNumber;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;
}
