package br.malandrim.schoolgradeapplication.service;

import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.exception.BusinessException;
import br.malandrim.schoolgradeapplication.repository.GradeRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public Grade save(Grade grade) {
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
}
