package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Column private String nome;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "teacher")
    private List<Grade> grades;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
