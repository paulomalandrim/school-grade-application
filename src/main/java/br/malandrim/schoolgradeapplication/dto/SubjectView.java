package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Subject;


public class SubjectView {

    private Long id;
    private String nome;

    public SubjectView(Subject subject) {
        this.id = subject.getId();
        this.nome = subject.getName();
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
