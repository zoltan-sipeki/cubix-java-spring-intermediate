package hu.cubix.zoltan_sipeki.student.mapper;

import org.mapstruct.Mapper;

import hu.cubix.zoltan_sipeki.student.dto.TeacherDto;
import hu.cubix.zoltan_sipeki.student.model.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    public TeacherDto mapTeacherToDto(Teacher teacher);
}
