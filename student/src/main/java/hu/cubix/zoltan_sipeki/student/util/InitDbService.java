package hu.cubix.zoltan_sipeki.student.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import hu.cubix.zoltan_sipeki.student.model.Course;
import hu.cubix.zoltan_sipeki.student.model.CourseStudent;
import hu.cubix.zoltan_sipeki.student.model.CourseTeacher;
import hu.cubix.zoltan_sipeki.student.model.Student;
import hu.cubix.zoltan_sipeki.student.model.Teacher;
import hu.cubix.zoltan_sipeki.student.repository.CourseRepository;
import hu.cubix.zoltan_sipeki.student.repository.CourseStudentRepository;
import hu.cubix.zoltan_sipeki.student.repository.CourseTeacherRepository;
import hu.cubix.zoltan_sipeki.student.repository.StudentRepository;
import hu.cubix.zoltan_sipeki.student.repository.TeacherRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InitDbService {

    private TestDataService testData;

    private CourseRepository courseRepo;

    private TeacherRepository teacherRepo;

    private StudentRepository studentRepo;
   
    private CourseTeacherRepository courseTeacherRepo;

    private CourseStudentRepository courseStudentRepo; 

    @Transactional
    public void init() throws StreamReadException, DatabindException, IOException, Throwable {
        deleteAll();
        initAll();
    }

    @Transactional
    public void deleteAll() {
        courseStudentRepo.deleteAllInBatch();
        courseTeacherRepo.deleteAllInBatch();
        studentRepo.deleteAllInBatch();
        courseRepo.deleteAllInBatch();
        teacherRepo.deleteAllInBatch();
    }

    @Transactional
    public void initAll() throws StreamReadException, DatabindException, IOException, Throwable {
        var students = testData.loadStudents();
        var courses = testData.loadCourses();
        var teachers = testData.loadTeachers();
        var courseStudents = createCourseStudents(courses, students);
        var courseTeachers = createCourseTeachers(courses, teachers);

        studentRepo.saveAll(students);
        courseRepo.saveAll(courses);
        teacherRepo.saveAll(teachers);
        courseStudentRepo.saveAll(courseStudents);
        courseTeacherRepo.saveAll(courseTeachers);
    }

    public List<CourseStudent> createCourseStudents(List<Course> courses, List<Student> students) {
        var result = new ArrayList<CourseStudent>();

        int studentCount = 10;
        int nextStudent = 0;
        for (var course : courses) {
            if (studentCount > 20) {
                studentCount = 10;
            }

            int upperbound = nextStudent + studentCount;
            for (int i = nextStudent; i < upperbound && i < students.size(); ++i) {
                result.add(CourseStudent.builder().student(students.get(i)).course(course).build());
            }

            ++studentCount;
        }

        return result;
    }

    public List<CourseTeacher> createCourseTeachers(List<Course> courses, List<Teacher> teachers) {
        var result = new ArrayList<CourseTeacher>();

        int teacherCount = 1;
        int nextTeacher = 0;
        for (var course : courses) {
            if (teacherCount > 2) {
                teacherCount = 1;
            }

            int upperbound = nextTeacher + teacherCount;
            for (int i = nextTeacher; i < upperbound && i < teachers.size(); ++i) {
                result.add(CourseTeacher.builder().teacher(teachers.get(i)).course(course).build());
            }

            ++teacherCount;
        }

        return result;
    }

}
