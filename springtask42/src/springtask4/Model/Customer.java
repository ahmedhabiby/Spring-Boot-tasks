package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="customer")
	private List<Orderr> orderrs;
}
