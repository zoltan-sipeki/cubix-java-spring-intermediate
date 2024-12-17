package hu.cubix.zoltan_sipeki.student.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Course {

    @EqualsAndHashCode.Include
    @GeneratedValue
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = CourseStudent_.COURSE)
    private Set<CourseStudent> students;

    @OneToMany(mappedBy = CourseTeacher_.COURSE)
    private Set<CourseTeacher> teachers;
}
