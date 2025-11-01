import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private int phone;
	@OneToOne(cascade = CascadeType.PERSIST ,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false,unique = true)
	private User1 user1;
	public Long getId() {
		return id;
	}
	public User_details() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	public User_details(String address, int phone) {
		super();
		this.address = address;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User_details [id=" + id + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
