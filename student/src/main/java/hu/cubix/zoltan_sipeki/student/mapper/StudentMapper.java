package hu.cubix.zoltan_sipeki.student.mapper;

import org.mapstruct.Mapper;

import hu.cubix.zoltan_sipeki.student.dto.StudentDto;
import hu.cubix.zoltan_sipeki.student.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    public StudentDto mapStudentToDto(Student student);
}
