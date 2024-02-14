package br.malandrim.schoolgradeapplication.dto;

import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.entity.Student;
import br.malandrim.schoolgradeapplication.entity.Subject;
import br.malandrim.schoolgradeapplication.entity.Teacher;
import br.malandrim.schoolgradeapplication.service.StudentService;
import br.malandrim.schoolgradeapplication.service.SubjectService;
import br.malandrim.schoolgradeapplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class GradeDto {
    private double grade;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;

    public GradeDto(double grade, Long studentId, Long subjectId, Long teacherId) {
        this.grade = grade;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public Grade toEntity(){

        Student student = new Student(studentId);
        Subject subject = new Subject(subjectId);
        Teacher teacher = new Teacher(teacherId);

        return new Grade(this.grade, student, subject, teacher);
    }
}
