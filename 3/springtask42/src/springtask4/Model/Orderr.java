package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orderr {

	@Id
	private Long id;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="cus_id")
	private Customer customer;
}
