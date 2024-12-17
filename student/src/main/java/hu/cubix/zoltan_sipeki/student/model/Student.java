package hu.cubix.zoltan_sipeki.student.model;

import java.time.LocalDate;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Cacheable
public class Student {

    @EqualsAndHashCode.Include
    @GeneratedValue
    @Id
    private int id;

    private String name;

    private LocalDate birthdate;

    private int semester;
}
