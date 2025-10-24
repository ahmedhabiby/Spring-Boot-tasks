package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Userr {

	@Id
	private Long Id;
	
	private String name;
	
	@ManyToMany(mappedBy="userrs")
	private List<Rolee> rolees;
}
