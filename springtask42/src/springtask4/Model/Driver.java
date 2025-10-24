package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver {
    @Id
    private Long id;
    private String driverName;

    @OneToOne(mappedBy = "driver")
    private Car car;
}
