package br.malandrim.schoolgradeapplication.repository;

import br.malandrim.schoolgradeapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
