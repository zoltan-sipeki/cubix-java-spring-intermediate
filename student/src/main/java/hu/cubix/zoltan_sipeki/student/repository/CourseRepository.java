package hu.cubix.zoltan_sipeki.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import hu.cubix.zoltan_sipeki.student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, QuerydslPredicateExecutor<Course> {

        @EntityGraph(attributePaths = { "students", "students.student" })
        @Query("select c from Course c where c.id in :courseIds")
        public List<Course> findWithStudents(List<Integer> courseIds);

        @EntityGraph(attributePaths = { "teachers", "teachers.teacher" })
        @Query("select c from Course c where c.id in :courseIds")
        public List<Course> findWithTeachers(List<Integer> courseIds);
}
