package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	private Long id;
	
	private String BookName;
	
	@ManyToOne
	@JoinColumn(name="auth_id")
	private Auther auther;
	
	    @ManyToOne
	    @JoinColumn(name = "library_id")
	    private Library library;
}
