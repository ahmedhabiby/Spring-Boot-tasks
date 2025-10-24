package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Rolee {

	@Id
	private Long id;
	
	private String roleName;
	
	@ManyToMany
	@JoinTable(name="user_role",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Userr> userrs;
}
