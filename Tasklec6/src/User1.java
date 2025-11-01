import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	
	

	public User1(String name, int age, List<Friends> friends) {
		super();
		this.name = name;
		this.age = age;
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User1 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public User1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	public User_details getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(User_details userDetail) {
		this.userDetail = userDetail;
	}

	public List<Friends> getFriends() {
		return friends;
	}

	public User1() {
		super();
	}

	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@OneToOne(mappedBy = "user1",fetch = FetchType.LAZY)
	private User_details userDetail;
	
	@ManyToMany(mappedBy = "user1s")
	private List<Friends> friends;

	@OneToMany(mappedBy = "user1")
	private List<Post> posts;
}
