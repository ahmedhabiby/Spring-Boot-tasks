package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Hospital {
	
	@Id
	private Long id;

	private String name;
	
	private int numberOfDoctors;
	
	private int numberOfPatient;
	
	@OneToMany(mappedBy="hospital")
	private List<Doctor> doctors;
	
	@ManyToMany(mappedBy="hospital")
	private List<Patient> patient;
}
