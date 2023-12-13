package com.codingdojo.studentroster1n.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name cannot be blank")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;

    public Student() {}

    public Student(Long id, String name, Dorm dorm) {
        this.id = id;
        this.name = name;
        this.dorm = dorm;
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

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }
}
