package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {
    @Id
    private Long id;
    private String parentName;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}
