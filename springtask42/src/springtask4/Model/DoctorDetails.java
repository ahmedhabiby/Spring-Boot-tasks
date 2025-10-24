package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DoctorDetails {
	
	@Id
	private Long id;

	private String firstName;
	
	private String fukkAddress;
	
	private String lastName;
	
	private int age;
	
	@OneToOne
	@JoinColumn(name="doc_id",
	unique=true,
	nullable=false)
	private Doctor doctor;
	
}
