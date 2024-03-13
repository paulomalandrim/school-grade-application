package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.entity.Student;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentView extends RepresentationModel<StudentView> {
    private Long id;
    private String name;
    private LocalDate nascimento;
    private List<GradeStudentView> gradeStudentViewList;


    public StudentView(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.nascimento = student.getNascimento();
        this.gradeStudentViewList = student.getGrades().stream()
                .map(GradeStudentView::new)
                .toList();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GradeStudentView> getGradeStudentViewList() {
        return gradeStudentViewList;
    }

    public void setGradeStudentViewList(List<GradeStudentView> gradeStudentViewList) {
        this.gradeStudentViewList = gradeStudentViewList;
    }
}
