package br.malandrim.schoolgradeapplication.controller;


import br.malandrim.schoolgradeapplication.dto.*;
import br.malandrim.schoolgradeapplication.entity.Subject;
import br.malandrim.schoolgradeapplication.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectResource {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectView> create(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectService.create(subjectDto.toEntity());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(new SubjectView(subject));
    }

    @GetMapping
    public ResponseEntity<List<SubjectView>> list(){
        List<Subject> subjectList = subjectService.findAll();
        List<SubjectView> subjectViewList = subjectList.stream()
                .map(SubjectView::new).toList();
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(subjectViewList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectView> find(@PathVariable Long id){
        Subject subject = subjectService.findById(id);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(new SubjectView(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectView> update(@RequestBody SubjectUpdateDto subjectUpdateDto,
                                              @PathVariable Long id){
        Subject subjectActual = subjectService.findById(id);
        Subject subjectToUpdate = subjectUpdateDto.toEntity(subjectActual);
        Subject subjectUpdated = subjectService.update(subjectToUpdate);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(new SubjectView(subjectUpdated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        subjectService.delete(id);
    }

}
