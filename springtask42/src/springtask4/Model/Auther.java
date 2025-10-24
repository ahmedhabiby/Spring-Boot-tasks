package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auther {

	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="auther")
	private List<Book> books;
}
