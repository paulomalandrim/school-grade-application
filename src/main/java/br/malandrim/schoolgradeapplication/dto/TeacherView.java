package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Teacher;

public class TeacherView {

    private Long id;
    private String nome;

    public TeacherView(Teacher teacher) {
        this.id = teacher.getId();
        this.nome = teacher.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
