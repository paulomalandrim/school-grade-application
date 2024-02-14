package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Teacher;

public class TeacherDto {
    private String nome;

    public TeacherDto(String nome) {
        this.nome = nome;
    }

    public Teacher toEntity(){
        return new Teacher(this.nome);
    }
}
