package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "grades")
public class Grade {
    private double grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;
    @ManyToOne private Teacher teacher;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Grade(double grade, Student student, Subject subject, Teacher teacher) {
        this.grade = grade;
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
    }

    public Grade(){
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
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

    public void setId(Long id) {
        this.id = id;
    }
}
