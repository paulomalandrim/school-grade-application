package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Subject;

public class SubjectDto {

    private String nome;

    public SubjectDto() {}

    public SubjectDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Subject toEntity(){ return new Subject(this.nome);
    }

}
