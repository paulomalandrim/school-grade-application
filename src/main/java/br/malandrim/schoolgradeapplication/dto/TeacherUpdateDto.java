package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Teacher;

public class TeacherUpdateDto {
    private String nome;

    public TeacherUpdateDto(){

    }
    public TeacherUpdateDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Teacher toEntity(Teacher teacher){

        return new Teacher(this.nome, teacher.getId());
    }
}
