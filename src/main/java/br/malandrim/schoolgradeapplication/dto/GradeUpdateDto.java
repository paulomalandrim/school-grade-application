package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.entity.Student;
import br.malandrim.schoolgradeapplication.entity.Subject;
import br.malandrim.schoolgradeapplication.entity.Teacher;
import br.malandrim.schoolgradeapplication.repository.StudentRepository;
import br.malandrim.schoolgradeapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class GradeUpdateDto {

    private double grade;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;

    @Autowired
    private StudentRepository studentRepository;

    public GradeUpdateDto(double grade, Long studentId, Long subjectId, Long teacherId) {
        this.grade = grade;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public Grade toEntity(Grade grade) {
        grade.setGrade(this.grade);
        grade.getStudent().setId(this.studentId);
        grade.getSubject().setId(this.subjectId);
        grade.getTeacher().setId(this.teacherId);
        return grade;
    }

}
