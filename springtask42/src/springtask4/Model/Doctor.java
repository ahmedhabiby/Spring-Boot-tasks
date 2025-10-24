package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Doctor {
	
	@Id
	private Long id;

	private String username;
	
	private double salary;
	
	@OneToOne(mappedBy="doctor")
	private DoctorDetails doctorDetails;
	
	@ManyToOne
	@JoinColumn(name="hos_id",
	nullable=false)
	private Hospital hospital;
	
	@OneToMany(mappedBy="doctor")
	private List<Patient> patient;
}
