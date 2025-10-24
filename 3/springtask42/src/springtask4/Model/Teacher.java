package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="teacher")
	private List<Subject> subjects;
}
