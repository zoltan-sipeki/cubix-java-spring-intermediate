package hu.cubix.zoltan_sipeki.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.zoltan_sipeki.student.dto.TeacherDto;
import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.mapper.TeacherMapper;
import hu.cubix.zoltan_sipeki.student.service.TeacherService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherRESTController {

    private TeacherService teacherService;

    private TeacherMapper teacherMapper;

    @GetMapping("/{id}")
    public TeacherDto findById(@PathVariable int id) throws EntityNotFoundException {
        var teacher = teacherService.findById(id);
        return teacherMapper.mapTeacherToDto(teacher);
    }
}
