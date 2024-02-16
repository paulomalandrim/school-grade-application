package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import static com.google.gson.internal.$Gson$Types.arrayOf;

@Entity
@Table(name = "students")
public class
Student {
    @Column private String name;
    @Column private LocalDate nascimento;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private List<Grade> grades;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(String name, LocalDate nascimento){
        this.name = name;
        this.nascimento = nascimento;
    }

    public Student(String name, LocalDate nascimento, Long id) {
        this.name = name;
        this.nascimento = nascimento;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
