package br.malandrim.schoolgradeapplication.repository;

import br.malandrim.schoolgradeapplication.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
