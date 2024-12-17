package hu.cubix.zoltan_sipeki.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import hu.cubix.zoltan_sipeki.student.dto.CourseSearchParamsDto;
import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.model.Course;
import hu.cubix.zoltan_sipeki.student.model.QCourse;
import hu.cubix.zoltan_sipeki.student.repository.CourseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseService {

    private CourseRepository courseRepo;

    public Course findById(int id) throws EntityNotFoundException {
        return courseRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("course", id));
    }

    @Transactional
    public List<Course> findAll(Pageable pageable, boolean isFull) {
        var courses = courseRepo.findAll(pageable).getContent();
        if (isFull) {
            loadRelationShips(courses);
        }

        return courses;
    }

    @Transactional
    public List<Course> findAll(CourseSearchParamsDto dto, Pageable pageable, boolean isFull) {
        var predicate = createPredicate(dto);
        var courses = courseRepo.findAll(predicate, pageable).getContent();
        
        if (isFull) {
            loadRelationShips(courses);
        }

        return courses;
    }

    @Transactional
    private void loadRelationShips(List<Course> courses) {
        var courseIds = courses.stream().map(Course::getId).toList();
        courseRepo.findWithStudents(courseIds);
        courseRepo.findWithTeachers(courseIds);
    }

    private Predicate createPredicate(CourseSearchParamsDto dto) {
        var course = QCourse.course;
        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(dto.teacher())) {
            predicates.add(course.teachers.any().teacher.name.startsWithIgnoreCase(dto.teacher()));
        }

        if (dto.id() != null) {
            predicates.add(course.id.eq(dto.id()));
        }

        if (StringUtils.hasText(dto.name())) {
            predicates.add(course.name.startsWithIgnoreCase(dto.name()));
        }

        if (dto.studentId() != null) {
            predicates.add(course.students.any().student.id.eq(dto.studentId()));
        }

        if (dto.semester() != null && !dto.semester().isEmpty()) {
            if (dto.semester().size() >= 2) {
                predicates.add(
                        course.students.any().student.semester.between(dto.semester().get(0), dto.semester().get(1)));
            } else {
                predicates.add(course.students.any().student.semester.eq(dto.semester().get(0)));
            }
        }

        return ExpressionUtils.allOf(predicates);
    }
}
