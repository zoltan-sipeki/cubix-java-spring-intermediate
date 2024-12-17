package hu.cubix.zoltan_sipeki.student.dto;

import java.time.LocalDate;

public record TeacherDto(
    int id,
    String name,
    LocalDate birthdate
) {

}
