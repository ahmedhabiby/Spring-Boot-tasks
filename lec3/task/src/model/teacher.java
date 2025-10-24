package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class teacher {

    @Id
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "teacher_name")
    @Size(max = 50)
    private String name;

    @Column(name = "teacher_age")
    @Min(value = 15)
    @Max(value = 20)
    private int age;

    @Override
	public String toString() {
		return "teacher [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	@Column(name = "teacher_address", unique = true)
    private String address;

    // Getters and Setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
