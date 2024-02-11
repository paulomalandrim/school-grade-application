package br.malandrim.schoolgradeapplication.repository;

import br.malandrim.schoolgradeapplication.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
