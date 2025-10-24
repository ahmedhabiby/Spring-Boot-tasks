package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {
    @Id
    private Long id;
    private String plateNumber;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
