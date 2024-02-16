package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Subject;

public class SubjectUpdateDto {
    private String nome;

    public SubjectUpdateDto(){

    }
    public SubjectUpdateDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Subject toEntity(Subject subject){
        return new Subject(this.nome, subject.getId());
    }

}
