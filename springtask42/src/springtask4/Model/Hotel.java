package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
    @Id
    private Long id;
    private String hotelName;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
