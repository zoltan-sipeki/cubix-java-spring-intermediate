package hu.cubix.zoltan_sipeki.student.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.cubix.zoltan_sipeki.student.model.Course;
import hu.cubix.zoltan_sipeki.student.model.Student;
import hu.cubix.zoltan_sipeki.student.model.Teacher;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TestDataService {

    private static final String STUDENT_FILE = "/testdata/student.json";
    
    private static final String TEACHER_FILE = "/testdata/teacher.json";
    
    private static final String COURSE_FILE = "/testdata/course.json";

    private ObjectMapper objectMapper;
    
    public List<Student> loadStudents() throws Throwable, DatabindException, IOException {
        var file = new File(getClass().getResource(STUDENT_FILE).getFile());
        var list = new ArrayList<Student>();
        Collections.addAll(list, objectMapper.readValue(file, Student[].class));
        return list;
    }

    public List<Teacher> loadTeachers() throws StreamReadException, DatabindException, IOException {
        var file = new File(getClass().getResource(TEACHER_FILE).getFile());
        var list = new ArrayList<Teacher>();
        Collections.addAll(list, objectMapper.readValue(file, Teacher[].class));
        return list;

    }

    public List<Course> loadCourses() throws StreamReadException, DatabindException, IOException {
        var file = new File(getClass().getResource(COURSE_FILE).getFile());
        var list = new ArrayList<Course>();
        Collections.addAll(list, objectMapper.readValue(file, Course[].class));
        return list;

    }
}
