package hu.cubix.zoltan_sipeki.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.zoltan_sipeki.student.dto.StudentDto;
import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.mapper.StudentMapper;
import hu.cubix.zoltan_sipeki.student.service.StudentService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentRESTController {

    private StudentService studentService;

    private StudentMapper studentMapper;
    
    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable int id) throws EntityNotFoundException {
        var student = studentService.findById(id);
        return studentMapper.mapStudentToDto(student);
    }
    
}
