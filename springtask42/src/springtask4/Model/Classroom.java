package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classroom {
    @Id
    private Long id;
    private String className;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
