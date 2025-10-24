package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name="stu_id")
	private Student student;
}
