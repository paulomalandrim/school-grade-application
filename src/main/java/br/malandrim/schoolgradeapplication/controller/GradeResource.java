package br.malandrim.schoolgradeapplication.controller;

import br.malandrim.schoolgradeapplication.dto.GradeDto;
import br.malandrim.schoolgradeapplication.dto.GradeUpdateDto;
import br.malandrim.schoolgradeapplication.dto.GradeView;
import br.malandrim.schoolgradeapplication.entity.Grade;
import br.malandrim.schoolgradeapplication.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeResource {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeView> create(@RequestBody GradeDto gradeDto){
        Grade savedGrade = gradeService.save(gradeDto.toEntity());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(new GradeView(savedGrade));
    }

    @GetMapping
    public ResponseEntity<List<GradeView>> list(){
        List<Grade> gradeList = gradeService.findAll();
        List<GradeView> gradeViewList = gradeList.stream()
                        .map(GradeView::new)
                        .toList();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(gradeViewList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeView> update(
            @PathVariable Long id,
            @RequestBody GradeUpdateDto gradeUpdateDto
    ){
        Grade grade = gradeService.findById(id);
        Grade gradeToUpdate = gradeUpdateDto.toEntity(grade);
        GradeView updatedGrade = new GradeView(gradeService.update(gradeToUpdate));
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(updatedGrade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        gradeService.deleteById(id);

    }
}
