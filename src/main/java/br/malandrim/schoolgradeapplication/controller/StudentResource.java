package br.malandrim.schoolgradeapplication.controller;

import br.malandrim.schoolgradeapplication.dto.StudentDto;
import br.malandrim.schoolgradeapplication.dto.StudentUpdateDto;
import br.malandrim.schoolgradeapplication.dto.StudentView;
import br.malandrim.schoolgradeapplication.entity.Student;
import br.malandrim.schoolgradeapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentView> create(@RequestBody StudentDto studentDto){
        Student student = studentService.create(studentDto.toEntity());
        StudentView studentView = new StudentView(student);
        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(studentView);
    }

    @GetMapping
    public ResponseEntity<List<StudentView>> list(){
        List<Student> studentList = studentService.findAll();
        List<StudentView> studentViewList = studentList.stream()
                .map(StudentView::new)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(studentViewList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentView> update(@RequestBody StudentUpdateDto studentUpdateDto,
                                              @PathVariable Long id){
        Student studentActual = studentService.findById(id);
        Student studentToUpdate = studentUpdateDto.toEntity(studentActual);
        Student studentUpdated = studentService.update(studentToUpdate);
        StudentView studentView = new StudentView(studentUpdated);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentView);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentView> find(@PathVariable Long id){
        Student student = studentService.findById(id);
        StudentView studentView = new StudentView(student);
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(studentView);
    }

    @GetMapping("/find")
    public ResponseEntity<List<StudentView>> findByName(@RequestParam String student_name){
        List<Student> studentList = studentService.findByName(student_name);
        List<StudentView> studentViewList = studentList.stream()
                .map(StudentView::new)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(studentViewList);
    }

}
