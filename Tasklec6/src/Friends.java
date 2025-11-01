import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Friends {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="user_friends")
	private List<User1> user1s;

	public Long getId() {
		return id;
	}

	public Friends(String name) {
		super();
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User1> getUser1s() {
		return user1s;
	}

	public void setUser1s(List<User1> user1s) {
		this.user1s = user1s;
	}

	public Friends(String name, List<User1> user1s) {
		this.name = name;
		this.user1s = user1s;
	}
	
}
