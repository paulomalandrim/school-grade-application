package br.malandrim.schoolgradeapplication.service;

import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.entity.Student;
import br.malandrim.schoolgradeapplication.exception.BusinessException;
import br.malandrim.schoolgradeapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id){
        if (!existsById(id)){
            throw new BusinessException("Id %d not found!".formatted(id));
        }
        studentRepository.deleteById(id);
    }

    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->
                new BusinessException("Id %d not found!".formatted(studentId))
        );
    }
    public List<Student> findByName(String studentName) {
        return studentRepository.findByName(studentName);
    }
}
