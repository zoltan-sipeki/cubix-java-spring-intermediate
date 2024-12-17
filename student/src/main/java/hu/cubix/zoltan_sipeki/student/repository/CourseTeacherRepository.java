package hu.cubix.zoltan_sipeki.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cubix.zoltan_sipeki.student.model.CourseTeacher;

@Repository
public interface CourseTeacherRepository extends JpaRepository<CourseTeacher, Integer> {

}
