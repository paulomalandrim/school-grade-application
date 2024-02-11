package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Column private String name;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;
    @ManyToOne private Teacher teacher;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }
}
