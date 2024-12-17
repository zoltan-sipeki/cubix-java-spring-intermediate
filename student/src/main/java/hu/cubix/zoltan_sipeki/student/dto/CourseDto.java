package hu.cubix.zoltan_sipeki.student.dto;

import java.util.List;

public record CourseDto(
    int id, 
    String name, 
    List<TeacherDto> teachers, 
    List<StudentDto> students 
) {

}
