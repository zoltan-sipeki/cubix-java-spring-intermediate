package hu.cubix.zoltan_sipeki.student.service;

import org.springframework.stereotype.Service;

import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.model.Student;
import hu.cubix.zoltan_sipeki.student.repository.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

    private StudentRepository studentRepo;

    public Student findById(int id) throws EntityNotFoundException {
        return studentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("student", id));
    }

}
