import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String header;
	private String content;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id",nullable = false)
	private User1 user1;

	

	public Post( String header, String content, User1 user1) {
		super();
	
		this.header = header;
		this.content = content;
		this.user1 = user1;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", header=" + header + ", content=" + content + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User1 getUser1() {
		return user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
}
