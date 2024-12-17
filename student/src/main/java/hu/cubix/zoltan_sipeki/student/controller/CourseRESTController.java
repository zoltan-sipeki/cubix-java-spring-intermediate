package hu.cubix.zoltan_sipeki.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.zoltan_sipeki.student.dto.CourseDto;
import hu.cubix.zoltan_sipeki.student.dto.CourseSearchParamsDto;
import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.mapper.CourseMapper;
import hu.cubix.zoltan_sipeki.student.model.Course;
import hu.cubix.zoltan_sipeki.student.service.CourseService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseRESTController {

    private CourseService courseService;

    private CourseMapper courseMapper;

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable int id) throws EntityNotFoundException {
        var course = courseService.findById(id);
        return courseMapper.mapCourseToDto(course);
    }

    @GetMapping
    public List<CourseDto> findCourses(CourseSearchParamsDto searchParams, @PageableDefault(sort = "name") Pageable pageable, @RequestParam Optional<Boolean> full) {
        boolean isFull = full.orElse(false);
        List<Course> courses = null;

        if (searchParams.isEmpty()) {
            courses = courseService.findAll(pageable, isFull);
        }
        else {
            courses = courseService.findAll(searchParams, pageable, isFull);
        }

        if (isFull) {
            return courseMapper.mapCourseListToFullDtoList(courses);
        }

        return courseMapper.mapCourseListToDtoList(courses);
    }

}
