package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {
    @Id
    private Long id;
    private String childName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
