package br.malandrim.schoolgradeapplication.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class StudentTest {

    @Test
    void mustCreateStudentPaulo() {
        Student student = new Student("Paulo", LocalDate.of(1985, 4, 9));
        Assertions.assertEquals("Paulo", student.getName());
    }

    @Test
    void mustHaveNullGrade(){
        Student student = new Student("Paulo", LocalDate.now().minusYears(20));
        Assertions.assertNull(student.getGrades());
    }

    
}
