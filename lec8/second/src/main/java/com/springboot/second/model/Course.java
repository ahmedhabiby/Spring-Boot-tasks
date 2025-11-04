package com.springboot.second.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student",
            joinColumns =
            @JoinColumn(name = "course_id"),
            inverseJoinColumns =
    @JoinColumn(name = "student_id"))
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
