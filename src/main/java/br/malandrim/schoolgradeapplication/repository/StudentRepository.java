package br.malandrim.schoolgradeapplication.repository;

import br.malandrim.schoolgradeapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student WHERE name = ?1", nativeQuery = true)
    List<Student> findByName(String name);
}
