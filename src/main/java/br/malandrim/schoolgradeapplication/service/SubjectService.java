package br.malandrim.schoolgradeapplication.service;

import br.malandrim.schoolgradeapplication.entity.Subject;
import br.malandrim.schoolgradeapplication.exception.BusinessException;
import br.malandrim.schoolgradeapplication.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject update(Subject subject){
        return subjectRepository.save(subject);
    }

    public void delete(Long id){
        if (!existsById(id)){
            throw new BusinessException("Id %d not found!".formatted(id));
        }
        subjectRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return subjectRepository.existsById(id);
    }

    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() ->
                new BusinessException("Id %d not found!".formatted(id))
        );
    }


}
