package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Column private String nome;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "teacher")
    private List<Grade> grades;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Teacher() {
    }

    public Teacher(Long id) {
        this.id = id;
    }

    public Teacher(String nome) {
        this.nome = nome;
    }

    public Teacher(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

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

    public void setId(Long id) {
        this.id = id;
    }
}
