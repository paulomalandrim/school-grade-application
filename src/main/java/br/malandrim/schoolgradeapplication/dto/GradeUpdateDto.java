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

   // @Autowired
   // private Grade gradeObj;

    @Autowired
    private StudentRepository studentRepository;

    public GradeUpdateDto(double grade, Long studentId, Long subjectId, Long teacherId) {
        this.grade = grade;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public Grade toEntity(Grade grade) {
        Grade gradeObj = new Grade();
        gradeObj.setId(grade.getId());
        gradeObj.setGrade(this.grade);
        gradeObj.setStudent(new Student(this.studentId));
        gradeObj.setSubject(new Subject(this.subjectId));
        gradeObj.setTeacher(new Teacher(this.teacherId));
        return gradeObj;
    }

}
