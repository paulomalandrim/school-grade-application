package br.malandrim.schoolgradeapplication.controller;

import br.malandrim.schoolgradeapplication.dto.TeacherDto;
import br.malandrim.schoolgradeapplication.dto.TeacherUpdateDto;
import br.malandrim.schoolgradeapplication.dto.TeacherView;
import br.malandrim.schoolgradeapplication.entity.Teacher;
import br.malandrim.schoolgradeapplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherView> create(@RequestBody TeacherDto teacherDto) {
        Teacher teacher = teacherService.create(teacherDto.toEntity());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(new TeacherView(teacher));
    }

    @GetMapping
    public ResponseEntity<List<TeacherView>> list(){
        List<Teacher> teachersList = teacherService.findAll();
        List<TeacherView> teacherViewList = teachersList.stream()
                .map(TeacherView::new).toList();
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(teacherViewList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherView> find(@PathVariable Long id){
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(new TeacherView(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherView> update(@RequestBody TeacherUpdateDto teacherUpdateDto,
                                              @PathVariable Long id){
        Teacher teacherActual = teacherService.findById(id);
        Teacher teacherToUpdate = teacherUpdateDto.toEntity(teacherActual);
        Teacher teacherUpdated = teacherService.update(teacherToUpdate);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(new TeacherView(teacherUpdated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        teacherService.delete(id);
    }

}
