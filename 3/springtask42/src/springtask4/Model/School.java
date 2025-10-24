package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
    @Id
    private Long id;
    private String schoolName;

    @OneToMany(mappedBy = "school")
    private List<Classroom> classrooms;
}
