package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="depart_id")
	private Department department;
	
	
	@ManyToMany
    @JoinTable(
        name = "project_employee",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

}
