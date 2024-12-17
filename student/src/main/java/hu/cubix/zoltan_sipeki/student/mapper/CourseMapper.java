package hu.cubix.zoltan_sipeki.student.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import hu.cubix.zoltan_sipeki.student.dto.CourseDto;
import hu.cubix.zoltan_sipeki.student.dto.StudentDto;
import hu.cubix.zoltan_sipeki.student.dto.TeacherDto;
import hu.cubix.zoltan_sipeki.student.model.Course;
import hu.cubix.zoltan_sipeki.student.model.CourseStudent;
import hu.cubix.zoltan_sipeki.student.model.CourseTeacher;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Named("CourseDto.default")
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    public CourseDto mapCourseToDto(Course course);

    @Named("CourseDto.full")
    public CourseDto mapCourseToFullDto(Course course);

    @IterableMapping(qualifiedByName = "CourseDto.default")
    public List<CourseDto> mapCourseListToDtoList(List<Course> courses);
    
    @IterableMapping(qualifiedByName = "CourseDto.full")
    public List<CourseDto> mapCourseListToFullDtoList(List<Course> courses);

    @Mapping(target = "id", source = "student.id")
    @Mapping(target = "name", source = "student.name")
    @Mapping(target = "birthdate", source = "student.birthdate")
    @Mapping(target = "semester", source = "student.semester")
    public StudentDto mapCourseStudentToStudentDto(CourseStudent student);

    @Mapping(target = "id", source = "teacher.id")
    @Mapping(target = "name", source = "teacher.name")
    @Mapping(target = "birthdate", source = "teacher.birthdate")
    public TeacherDto mapCourseTeacherToTeacherDto(CourseTeacher teacher);
}
