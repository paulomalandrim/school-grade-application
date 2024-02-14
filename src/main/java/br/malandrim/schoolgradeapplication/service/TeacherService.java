package br.malandrim.schoolgradeapplication.service;

import br.malandrim.schoolgradeapplication.entity.Teacher;
import br.malandrim.schoolgradeapplication.exception.BusinessException;
import br.malandrim.schoolgradeapplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher update(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void delete(Long id){
        if (!existsById(id)){
            throw new BusinessException("Id %d not found!".formatted(id));
        }
        teacherRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return teacherRepository.existsById(id);
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() ->
                new BusinessException("Id %d not found!".formatted(id))
        );
    }


}
