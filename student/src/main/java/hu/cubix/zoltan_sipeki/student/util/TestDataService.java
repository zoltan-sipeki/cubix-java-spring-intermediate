package hu.cubix.zoltan_sipeki.student.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
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
        return loadJSON(STUDENT_FILE, Student.class);
    }

    public List<Teacher> loadTeachers() throws StreamReadException, DatabindException, IOException {
        return loadJSON(TEACHER_FILE, Teacher.class);
    }

    public List<Course> loadCourses() throws StreamReadException, DatabindException, IOException {
        return loadJSON(COURSE_FILE, Course.class);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> loadJSON(String path, Class<T> type) throws StreamReadException, DatabindException, IOException {
        var file = new File(getClass().getResource(path).getFile());
        var list = new ArrayList<T>();
        Collections.addAll(list, (T[]) objectMapper.readValue(file, Array.newInstance(type, 0).getClass()));
        return list;
    }
}
