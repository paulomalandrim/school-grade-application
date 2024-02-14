package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Teacher;

public class TeacherUpdateDto {

    private Long id;

    private String nome;


    public TeacherUpdateDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Teacher toEntity(Teacher teacher){
        return new Teacher(teacher.getNome(),teacher.getId());
    }
}
