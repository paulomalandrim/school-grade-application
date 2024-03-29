package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Teacher;

public class TeacherDto {
    private String nome;

    public TeacherDto() {}

    public TeacherDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Teacher toEntity(){
        return new Teacher(this.nome);
    }
}
