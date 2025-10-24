package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
    @Id
    private Long id;
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
