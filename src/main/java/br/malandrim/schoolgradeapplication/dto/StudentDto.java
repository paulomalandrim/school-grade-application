package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Student;

import java.time.LocalDate;

public class StudentDto {
    private String name;
    private LocalDate nascimento;

    public StudentDto() {
    }

    public StudentDto(String name, LocalDate nascimento) {
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

    public Student toEntity(){
        return new Student(this.name, this.nascimento);
    }
}
