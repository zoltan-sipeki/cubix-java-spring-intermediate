package hu.cubix.zoltan_sipeki.student.service;

import org.springframework.stereotype.Service;

import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;
import hu.cubix.zoltan_sipeki.student.model.Teacher;
import hu.cubix.zoltan_sipeki.student.repository.TeacherRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TeacherService {

    private TeacherRepository teacherRepo;

    public Teacher findById(int id) throws EntityNotFoundException {
        return teacherRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("teacher", id));
    }
}
