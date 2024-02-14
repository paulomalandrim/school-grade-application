package br.malandrim.schoolgradeapplication.service;

import br.malandrim.schoolgradeapplication.controller.SubjectResource;
import br.malandrim.schoolgradeapplication.controller.TeacherResource;
import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.entity.Student;
import br.malandrim.schoolgradeapplication.exception.BusinessException;
import br.malandrim.schoolgradeapplication.repository.GradeRepository;
import br.malandrim.schoolgradeapplication.repository.StudentRepository;
import br.malandrim.schoolgradeapplication.repository.SubjectRepository;
import br.malandrim.schoolgradeapplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade update(Grade grade) {
        if (!existsById(grade.getId())){
            throw new IllegalArgumentException("Grade %d not found".formatted(grade.getId()));
        }
        if (!studentRepository.existsById(grade.getStudent().getId())){
            throw new IllegalArgumentException("Invalid Student");
        }
        if (!teacherRepository.existsById(grade.getTeacher().getId())){
            throw new IllegalArgumentException("Invalid Teacher");
        }
        if (!subjectRepository.existsById(grade.getSubject().getId())){
            throw new IllegalArgumentException("Invalid Subject");
        }
        return gradeRepository.save(grade);
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public boolean existsById(Long gradeId) {
        return gradeRepository.existsById(gradeId);
    }

    public Grade findById(Long gradeId) {
        return gradeRepository.findById(gradeId).orElseThrow(() ->
                new BusinessException("Id %d not found!".formatted(gradeId))
        );
    }

    public void deleteById(Long gradeId) {
        if (!existsById(gradeId)){
            throw new IllegalArgumentException("grade %d not found".formatted(gradeId));
        }
        gradeRepository.deleteById(gradeId);
    }
}
