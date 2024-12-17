package hu.cubix.zoltan_sipeki.student.dto;

import java.time.LocalDate;

public record StudentDto(
    int id,
    String name,
    LocalDate birthdate,
    int semester
) {

}
