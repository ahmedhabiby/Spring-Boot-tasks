package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
    @Id
    private Long id;
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
