package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
	
	@Id
	private Long id;
	
	private String bodySubject;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;

	 @ManyToMany
	    @JoinTable(
	        name = "course_student",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	    private List<Course> courses;
}
