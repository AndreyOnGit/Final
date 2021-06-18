package ru.geekbrains.student.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.student.dto.StudentDto;
import ru.geekbrains.student.services.StudentService;
import ru.geekbrains.student.models.Student;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping      /*http://localhost:8189/student/index.html*/
    public Page<StudentDto> findAllProducts(
            @RequestParam(name = "page", defaultValue = "1") Integer pg
    ) {
        if (pg < 1) {
            pg = 1;
        }
        return studentService.getStudents(pg - 1, 10);
    }

    @GetMapping("/{id}")
    public StudentDto findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //ответ 201
    public StudentDto saveOrUpdate(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
