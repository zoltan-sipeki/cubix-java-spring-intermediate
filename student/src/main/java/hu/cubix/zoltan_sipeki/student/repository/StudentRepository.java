package hu.cubix.zoltan_sipeki.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cubix.zoltan_sipeki.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
