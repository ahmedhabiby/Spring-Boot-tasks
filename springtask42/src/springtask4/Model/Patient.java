package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	
	@Id
	private Long id;

	private String name;
	
	private String typeOfDisease;
	
	@ManyToOne
	@JoinColumn(name="doc_id",
	nullable=false)
	private Doctor doctor;
	
	
	@ManyToMany
	@JoinTable(name="hos_patient",
	joinColumns=@JoinColumn(name="hos_id"),
	inverseJoinColumns=@JoinColumn(name="patient_id"))
	private List<Hospital> hospital;
}
