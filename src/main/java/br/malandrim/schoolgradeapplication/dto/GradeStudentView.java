package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Grade;

public class GradeStudentView {

    private double grade;

    private String subjectName;

    private String teacherName;

    public GradeStudentView(Grade grade) {
        this.grade = grade.getGrade();
        this.subjectName = grade.getSubject().getName();
        this.teacherName = grade.getTeacher().getNome();
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
