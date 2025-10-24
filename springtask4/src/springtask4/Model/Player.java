package springtask4.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class Player {

	@Id
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	public Player(Long id, String name, @Max(10) int age, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + "]";
	}

	public Player() {
		
	}

	public Long getId() {
		return id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Size(max=10)
	private int age;
	
	private boolean status;
}
