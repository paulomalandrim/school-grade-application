package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Student;

import java.time.LocalDate;

public class StudentUpdateDto {
    private String name;
    private LocalDate nascimento;

    public StudentUpdateDto() {
    }

    public StudentUpdateDto(String name, LocalDate nascimento) {
        this.name = name;
        this.nascimento = nascimento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Student toEntity(Student student){
        return new Student(this.name, this.nascimento, student.getId());
    }
}
