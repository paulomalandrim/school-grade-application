package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.gson.internal.$Gson$Types.arrayOf;

@Entity
public class Student {
    @Column private String name;
    @Column private LocalDateTime nascimento;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private List<Grade> grades;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
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


}
