package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Column private String name;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "subject")
    private List<Grade> grades;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Subject(Long id) {
        this.id = id;
    }

    public Subject(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
