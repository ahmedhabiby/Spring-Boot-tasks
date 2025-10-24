package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	private Long id;
	
	private String departmentName;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employee;
	
}
