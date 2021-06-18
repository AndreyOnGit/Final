package ru.geekbrains.student.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.student.dto.StudentDto;
import ru.geekbrains.student.models.Student;
import ru.geekbrains.student.repositories.StudentRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Optional<StudentDto> findStudentById(Long id) {
        return Optional.of(new StudentDto(studentRepository.findById(id).get()));
    }

    public StudentDto saveOrUpdate(Student product) {
        return new StudentDto(studentRepository.save(product));
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    public Page<StudentDto> getStudents(int page, int size) {
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(page, size));
        return new PageImpl<>(studentPage.stream().map(StudentDto::new).collect(Collectors.toList()), studentPage.getPageable(), studentPage.getTotalElements());
    }
}
