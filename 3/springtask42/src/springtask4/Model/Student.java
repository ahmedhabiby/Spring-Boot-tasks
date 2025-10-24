package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy="student")
	private Passport passport;
}
