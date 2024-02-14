package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Grade;

public class GradeView {

    private double grade;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;

    public GradeView(Grade grade){
        this.grade = grade.getGrade();
        this.studentId = grade.getStudent().getId();
        this.subjectId = grade.getSubject().getId();
        this.teacherId = grade.getTeacher().getId();
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
